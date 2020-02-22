package domain;

public class Atm {
    private String aname;
    private String apw;
    private Float abalance;

    public Atm() {
    }

    public Atm(String aname, String apw, Float abalance) {
        this.aname = aname;
        this.apw = apw;
        this.abalance = abalance;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApw() {
        return apw;
    }

    public void setApw(String apw) {
        this.apw = apw;
    }

    public Float getAbalance() {
        return abalance;
    }

    public void setAbalance(Float abalance) {
        this.abalance = abalance;
    }
}
