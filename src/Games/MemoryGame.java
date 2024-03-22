package Games;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class MemoryGame {
    //필드
    //생성자
    //메소드
    public boolean startGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("──────────────────────────────────────────");
        System.out.println("\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠟⠛⠛⠙⠙⠙⠋⠛⠛⠻⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠋⣁⣤⣦⣶⣷⣿⣿⣿⣿⣿⣿⣾⣶⣶⣤⣄⣉⠙⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⣠⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣧⣄⠉⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢁⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⡉⠛⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡈⠻⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⢠⣾⣿⣿⣿⣿⣿⣿⡿⡿⡿⠋⣠⣾⣿⣿⣿⣶⡀⢉⣁⣀⣁⡙⠻⣿⣿⣿⣷⣄⠙⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢀⣿⣿⣿⣿⣿⣿⠟⢁⣤⣤⣤⣄⠘⢿⣿⣿⣿⣿⠛⠛⠛⢿⣿⣿⣆⠘⣿⣿⣿⣿⣆⠨⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⣾⣿⣿⣿⣿⣿⠇⢰⣿⣿⣿⣿⣿⣅⣸⣿⣿⣿⣿⣿⣿⣧⣬⣿⣿⣿⠀⣺⣿⣿⣿⣿⡆⠸⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡯⠀⣿⣿⣿⣿⠟⢉⣀⠘⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⢁⣄⡈⠛⣿⣿⣿⣿⠀⣻⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡯⠀⣿⣿⣿⠃⣰⣿⣿⣷⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣦⠘⣿⣿⣿⡆⢸⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⠿⠋⣁⣴⣿⣿⣿⠀⣺⣿⣿⣿⣿⣿⣿⠛⢙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⣿⣿⣿⡇⠰⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⡿⠛⢁⣴⣾⣿⣿⣿⣿⣿⣧⠈⠻⣿⣿⣿⣿⠃⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⠿⠋⣁⣼⣿⣿⣿⡇⢘⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⡃⠸⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣄⣁⣁⣁⣀⣈⣈⣈⣈⣈⣈⣈⡉⠻⣿⣿⡟⠁⣤⣦⣶⣾⣿⣿⣿⣿⣿⡇⢨⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣶⡀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⢽⣿⡇⠨⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣺⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⡿⠃⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠈⠿⠇⠨⣿⣿⣿⣿⣿⣿⣿⣿⠇⢰⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⡧⠈⢛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣾⣿⣿⣿⣿⣿⣿⣿⠋⢠⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣇⠘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⣠⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⡶⠀⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⣰⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⠁⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣦⡈⠛⠿⠿⣿⢿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣦⣤⣤⣤⣤⣀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡗⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡃⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄⢽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣤⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣤⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");

        System.out.println();
        System.out.println();
        System.out.println("\u001B[36m" + "▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("▌ Welcome to Memory Game! \uD83E\uDD14▐");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ \n");
        System.out.println("┌──────────────────────────────────────────────────────┐");
        System.out.println("  ※ 0 ~ 50 사이의 랜덤숫자 5개를 기억한 뒤 입력하는 게임! ※ ");
        System.out.println("└──────────────────────────────────────────────────────┘");


        int[] sequence = generateSequence(5);
        displaySequence(sequence);

        System.out.println();
        System.out.println("\u001B[0m" + "자 정답을 하나씩 입력해주세요!");

        boolean correct = checkSequence(sequence, scanner);

        if (correct) {
            System.out.println("와우 대단해요! 모든 숫자들을 맞추었어요!");
        } else {
            System.out.println("땡.. 다시 도전하세요!");
        }
        return correct;
    }

    public static int[] generateSequence(int length) {
        int[] sequence = new int[length];
        for (int i = 0; i < length; i++) {
            sequence[i] = (int)((Math.random() * 50)+1);
        }
        return sequence;
    }

    public static void displaySequence(int[] sequence) {
        //JFrame은 Java Swing 클래스의 일부, 구현되는 하나의 창
        //Swing은 자바에서 그래픽 사용자 인터페이스를 구현하기 위해 제공되는 클래스
        JFrame frame = new JFrame("메모리 게임");
        //JPanel은 그룹핑하는 역할에 충실한 컨테이너
        JPanel panel = new JPanel();
        String number;

        System.out.println();
        System.out.println();

        frame.setSize(300, 300);                //창 크기 설정
        frame.setResizable(false);              //사용자 크기 조정 여부
        frame.setAlwaysOnTop(true);             //화면 맨 앞으로 보내는 창
        frame.setLocationRelativeTo(null);      //화면 가운데에 띄우기
        frame.setVisible(true);                 //화면에 보이게 하기

        System.out.println("\u001B[0m" + "짠! 5초 뒤 사라집니다~");

        number = String.valueOf(sequence[0]);
        for (int i=1; i<sequence.length; i++) {
            number += ", " + sequence[i];
        }

        JLabel label = new JLabel(number);      //JPanel에 넣을 JLabel생성
        panel.setLayout(new GridBagLayout());
        panel.add(label);
        frame.add(panel);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        frame.dispose();        //자동으로 창 닫기
    }

    public static boolean checkSequence(int[] sequence, Scanner scanner) {
        int count = 1;
        for (int num : sequence) {
            System.out.print(count + "번째 : ");
            count++;
            int input = scanner.nextInt();
            if (input != num) {
                return false;
            }
        }
        return true;
    }
}