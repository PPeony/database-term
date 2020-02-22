package domain;

public class User {
    private String name;
    private String password;
    private String ID;//编号
    private String IDCard;//身份证

    public User() {
    }

    public User(String name, String password, String ID, String IDCard) {
        this.name = name;
        this.password = password;
        this.ID = ID;
        this.IDCard = IDCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }
}
