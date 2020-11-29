package enums;

public enum GameProcess {
    NO_COUNT(0),
    OUT_3STIRKE(3);

    int value = -1;

    GameProcess(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
