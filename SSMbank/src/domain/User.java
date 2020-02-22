package domain;

public class User {
    private String userName;
    private String userPw;
    private String userID;//编号
    private String userIDCard;//身份证

    public User() {
    }

    public User(String userName, String userPw, String userID, String userIDCard) {
        this.userName = userName;
        this.userPw = userPw;
        this.userID = userID;
        this.userIDCard = userIDCard;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserIDCard() {
        return userIDCard;
    }

    public void setUserIDCard(String userIDCard) {
        this.userIDCard = userIDCard;
    }
}
