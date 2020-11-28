package enums;

public enum GameProcess {
    NO_COUNT(0),
    OUT_3STIRKE(3),
    ACCEPT_REGAME(1),
    REJECT_REGAME(2);

    int value = -1;

    GameProcess(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
