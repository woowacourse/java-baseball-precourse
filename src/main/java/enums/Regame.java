package enums;

public enum Regame {
    ACCEPT("1"),
    REJECT("2");

    String value = "";

    Regame(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
