package baseball.resource.rule;

public enum NumberRange {

    START(1), END(9);

    private final int number;

    NumberRange(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }


}
