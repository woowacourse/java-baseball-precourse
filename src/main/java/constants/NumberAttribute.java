package constants;


public enum NumberAttribute {

    DIGIT_NUMBER(3),
    RADIX(10),
    MIN_RANGE(1),
    MAX_RANGE(9);

    private final int value;

    NumberAttribute(int value) {

        this.value = value;
    }

    public int getValue() {

        return value;
    }
}
