package Games;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HangManGame {
    // 필드
    private String[] words; // 게임에 사용될 단어들
    private int maxAttempts; // 최대 시도 횟수

    //Java Collection Framework의 인터페이스
    //데이터 자료구조 중에 하나로 특정한 값들을 저장하는 추상자료형
    //값들의 순서가 존재하지 않으며 중복되지 않음
    //중복해서 삽입 불가능, 동일한 값이 삽입되면 하나의 값만 저장됨
    //Character는 char형의 래퍼클래스
    //선언만 생성자에서 객체 생성
    private Set<Character> guessedLetters; // 이미 추측한 알파벳을 저장하는 집합

    Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성

    // 생성자
    public HangManGame() {
        words = new String[]{"hangman", "java", "programming", "computer", "developer", "game", "apple", "samsung", "eclipse", "void", "public", "class", "println", "comment", "operator", "constant", "underbar", "overflow", "char", "string"}; // words 배열을 받아 필드에 할당
        maxAttempts = 15; // 최대 시도 횟수 설정

        // 이미 추측한 알파벳을 저장할 집합 초기화
        // HashSet은 Set을 구현하는 대표 클래스, 데이터를 중복할 수 없고 순서를 보장하지 않음
        // 그외에도 TreeSet, LinkedHashSet
        guessedLetters = new HashSet<>();
    }

    // 게임 시작 메소드
    public boolean startGame() {
        boolean result = false; // 게임 결과를 저장할 변수

        // 게임 시작 메시지 출력
        System.out.println();
        System.out.println(
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⠿⠿⠿⡿⠿⠿⠿⢿⠿⠿⢿⠿⠿⢿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⢴⣴⣴⣴⣴⣤⣦⣦⣦⣦⣴⣴⣤⣦⣦⣆⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣗⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠓⠀⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⣠⣶⣶⣶⡀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⠀⣾⣿⣿⣿⡗⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⡈⠛⠛⠋⣀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣗⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⢀⠀⡀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⣀⣾⡯⠀⣿⣦⡈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣤⣶⣿⣿⡯⠀⣿⣿⣿⣤⣬⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡯⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⡀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⣰⣷⣄⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⢀⣼⣿⣿⣿⣦⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⣠⣾⣿⣿⣿⣿⣿⣷⡀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣿⣿⣿⣿⣿⣿⣿⣿⣷⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣯⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣯⣽⣿⣿⣿⣿⣿⣿⣿⣿⡟⠛⠛⠛⠛⠛⠀⠚⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣶⣶⣶⣾⣶⣾⣶⣷⣾⣶⣾⣶⣶⣶⣷⣶⣷⣶⣶⣷⣶⣷⣾⣶⣷⣾⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⡷⢽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");

        // 랜덤으로 단어 선택
        int random = (int)(Math.random() * words.length);
        String wordToGuess = words[random];

        // 추측한 단어 상태를 나타내는 StringBuilder 객체 생성
        // StringBuilder 클래스는 문자를 추가하거나 삭제할 때 인스턴스 생성을 최소화함으로 성능을 향상
        // StringBuilder 클래스는 문자열을 추가, 삭제, 변경할 수 있는 메서드를 제공하며, String 클래스보다 우수한 성능
        // StringBuilder의 경우 문자열 데이터를 다룬다는 점에서 String 객체와 같지만, 객체의 공간이 부족해지는 경우 버퍼의 크기를 유연하게 늘려주어 가변적이라는 차이점
        // repeat는 String 메서드 중 하나로 String 문자열을 파라미터의 주어진 횟수만큼 반복
        StringBuilder guessedWord = new StringBuilder("_".repeat(wordToGuess.length()));

        // 시도 횟수 초기화
        int attempts = 0;

        System.out.println(); System.out.println();
        System.out.println("\u001B[36m" + "▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("▌ 행맨 게임을 시작합니다. ▌");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬ \n");
        System.out.println("┌─────────────────────────────────┐");
        System.out.println("  게임에서 맞춰야 할 단어의 길이: " + (words[random].length()));
        System.out.println("          주어진 기회: " + maxAttempts);
        System.out.println("└─────────────────────────────────┘" + "\u001B[0m");
        System.out.println();
        System.out.println("──────────────────────────────");
        System.out.println();

        // 이미 추측한 알파벳을 저장하는 집합 초기화
        guessedLetters.clear();

        // 게임 플레이 루프
        while (attempts <= maxAttempts) {
            // 현재 추측 상태 출력
            System.out.println("현재 상태: " + guessedWord);
            // 사용자 입력 받기
            System.out.print("알파벳을 한 글자 입력하세요 : ");
            String input = sc.next();

            // 한 글자가 아닌 경우 처리
            if (input.length() != 1) {
                System.out.println();
                System.out.println("한 글자만 입력해주세요!");
                System.out.println();
                continue;
            }

            //길이가 0보다 작지 않기 때문에 양의 정수 입력
            //지정된 인덱스의 char 값을 반환하지만 매개 변수 값이 음수이거나 문자열 길이보다 크면 예외가 발생
            char guess = input.charAt(0);

            // 이미 추측한 알파벳인지 확인
            // Set은 index로 관리하지 않기 때문에 반복자를 이용해서 접근하면 안됨
            // contains는 항목이 HashSet의 인스턴스에 있는지 여부를 확인하는 메서드
            if (guessedLetters.contains(guess)) {
                System.out.println();
                System.out.println("이미 추측한 알파벳입니다. 다른 알파벳을 입력하세요.");
                System.out.println();
                continue;               // 이미 추측한 알파벳이면 다음 글자로 넘어감
            }

            // 추측한 알파벳 추가
            guessedLetters.add(guess);

            // 정답인지 확인하고 상태 업데이트
            boolean correctGuess = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedWord.setCharAt(i, guess);
                    correctGuess = true;
                }
            }

            // 추측 결과에 따른 메시지 출력
            if (!correctGuess) {
                System.out.println();
                System.out.println(guess + "는 틀렸습니다!");
                System.out.println();
                attempts++; // 시도 횟수 증가
            } else {
                System.out.println();
                System.out.println(guess + "는 맞았습니다!");
                System.out.println();
            }

            // 정답을 모두 맞췄는지 확인
            if (guessedWord.toString().equals(wordToGuess)) {
                System.out.println();
                System.out.println("축하합니다! 단어를 맞췄습니다!");
                System.out.println();
                result = true;
                return result;
            }

            // 마지막 기회인 경우 메시지 출력
            if (maxAttempts - attempts == 1) {
                System.out.println("마지막 기회입니다. 정답을 맞추세요!");
            }

            // 남은 기회 출력
            System.out.println("\u001B[33m" + "남은 기회: " + (maxAttempts - attempts) + "\u001B[0m");

            // 시도 횟수가 최대 시도 횟수를 초과한 경우 패배 메시지 출력
            if (attempts >= maxAttempts) {
                System.out.println();
                System.out.println("주어진 기회를 모두 사용했습니다. 패배입니다.");
                System.out.println("정답은: " + wordToGuess);
                return result;
            }
        }

        return result;
    }
}