package domain;

public class Trans {
    private String cardID;
    private String transType;
    private Float transMoney;
    private String transDate;//日期类型

    public Trans() {
    }

    public Trans(String cardID, String transType, Float transMoney, String transDate) {
        this.cardID = cardID;
        this.transType = transType;
        this.transMoney = transMoney;
        this.transDate = transDate;
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
        return transDate;
    }

    public void setDate(String transDate) {
        this.transDate = transDate;
    }
}
