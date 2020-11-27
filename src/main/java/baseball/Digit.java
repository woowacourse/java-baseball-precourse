package baseball;

public class Digit {
    private static final int MIN = 1;
    private static final int MAX = 9;
    private final int digit;

    Digit(int input){
        if (input < MIN || MAX < input) {
            throw new IllegalArgumentException("각 자리수의 숫자는 1 이상 9 이하여야 합니다.");
        }
        this.digit = input;
    }

    public int getDigit(){
        return this.digit;
    }
}
