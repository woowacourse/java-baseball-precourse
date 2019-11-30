package Baseball;

public enum Will {
    WantToPlay(1),
    WantToStop(2);

    private int value;

    Will(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

