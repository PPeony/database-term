package domain;

public class User {
    private String name;
    private String password;
    private String ID;//编号
    private String IDcard;//身份证
    public User(){}
    public User(String ID,String name,String IDcard,String password){
        this.ID=ID;
        this.name=name;
        this.IDcard=IDcard;
        this.password=password;
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

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }
}
