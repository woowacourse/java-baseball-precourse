package enums;

public enum GameProcess {
    OUT_3STIRKE(3),
    ACCEPT_REGAME(1),
    REJECT_REGAME(2);

    int value = 0;

    GameProcess(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
