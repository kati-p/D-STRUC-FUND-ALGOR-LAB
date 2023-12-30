package datastr;

public class ARI {
    private String s;
    private String back;
    private String backR;

    public ARI(String v1, String v2, String v3) {
        s = v1;
        back = v2;
        backR = v3;
    }

    public void setS(String s) {
        this.s = s;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public void setBackR(String backR) {
        this.backR = backR;
    }

    public String toString() {
        return "s = " + s + "\n"
                + "back = " + back + "\n"
                + "backR = " + backR;
    }

}
