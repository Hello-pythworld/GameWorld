package GameSQL;

public class GameUser {
    //필드
    private String gId;
    private String gPw;
    private String gName;

    //생성자
    public GameUser() { }

    //메소드
    //getter and setter
    public String getgId() {
        return gId;
    }
    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getgPw() {
        return gPw;
    }
    public void setgPw(String gPw) {
        this.gPw = gPw;
    }

    public String getgName() {
        return gName;
    }
    public void setgName(String gName) {
        this.gName = gName;
    }
}