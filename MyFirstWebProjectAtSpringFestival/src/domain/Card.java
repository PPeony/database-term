package domain;

public class Card {
    private String userID;
    private String cardID;
    private String cardPw;
    private Float cardMoney;

    public Card() {
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
