package baseball;

import interfaces.IBaseballGameNumber;

public class BaseballGameNumber implements IBaseballGameNumber {
    public static final int SIZE_OF_ARRAY = 3;

    public static final int MIN_NUMBER_RANGE = 1;
    public static final int MAX_NUMBER_RANGE = 9;

    private int[] numbers;

    public BaseballGameNumber() {
        numbers = new int[SIZE_OF_ARRAY];
    }

    @Override
    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public int[] getNumbers() {
        return this.numbers;
    }
}
