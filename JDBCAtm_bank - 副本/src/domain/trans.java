package domain;

public class trans {
    private String cardID;
    private String transType;
    private Float transMoney;
    private String date;//日期类型

    public trans() {
    }

    public trans(String cardID, String transType, Float transMoney, String date) {
        this.cardID = cardID;
        this.transType = transType;
        this.transMoney = transMoney;
        this.date = date;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public Float getTransMoney() {
        return transMoney;
    }

    public void setTransMoney(Float transMoney) {
        this.transMoney = transMoney;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
