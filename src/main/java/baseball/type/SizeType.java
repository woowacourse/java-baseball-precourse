package baseball.type;

public enum SizeType {
    NUMBER_SIZE(3),
    FLAG_SIZE(10);

    private final int size;

    SizeType(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
