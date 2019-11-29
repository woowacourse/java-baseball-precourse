package Baseball;

public enum Will {
    WantToPlay(1),
    WantToStop(2);

    private Integer value;
    Will(int value) {
        this.value = value;
    }
}
