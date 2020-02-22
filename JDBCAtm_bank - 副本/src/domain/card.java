package domain;

public class card {
    private String userID;
    private String cardID;
    private String cardPw;
    private Float cardMoney;

    public card() {
    }

    public card(String userID, String cardID, String cardPw, Float cardMoney){
        this.userID=userID;
        this.cardID=cardID;
        this.cardPw=cardPw;
        this.cardMoney=cardMoney;
    }
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getCardPw() {
        return cardPw;
    }

    public void setCardPw(String cardPw) {
        this.cardPw = cardPw;
    }

    public Float getCardMoney() {
        return cardMoney;
    }

    public void setCardMoney(Float cardMoney) {
        this.cardMoney = cardMoney;
    }
}
