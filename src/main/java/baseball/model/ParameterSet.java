package baseball.model;

public class ParameterSet {
    private int numberOfDigits;
    private int minDigit;
    private int maxDigit;

    public ParameterSet(int givenNumberOfDigits, int givenMinDigit, int givenMaxDigit) {
        numberOfDigits = givenNumberOfDigits;
        minDigit = givenMinDigit;
        maxDigit = givenMaxDigit;
    }

    public int numberOfDigits() {
        return numberOfDigits;
    }

    public int minDigit() {
        return minDigit;
    }

    public int maxDigit() {
        return maxDigit;
    }
}
