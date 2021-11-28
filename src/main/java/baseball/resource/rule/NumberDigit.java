package baseball.resource.rule;

import baseball.exception.InputNumbersNotMatchDigitsMessageException;

public enum NumberDigit {

    COUNT(3);

    private final int count;

    NumberDigit(int length) {
        this.count = length;
    }

    public int getCount() {
        return this.count;
    }

    public boolean isMatch(int count) {
        if (this.count != count) {
            throw new InputNumbersNotMatchDigitsMessageException();
        }
        return true;
    }

}
