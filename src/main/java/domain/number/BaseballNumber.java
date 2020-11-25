package domain.number;

public class BaseballNumber {

    private final int baseballNumber;

    public BaseballNumber(int baseballNumber) {
        if (baseballNumber < 1 || baseballNumber > 9) {
            throw new IllegalArgumentException();
        }
        this.baseballNumber = baseballNumber;
    }
}
