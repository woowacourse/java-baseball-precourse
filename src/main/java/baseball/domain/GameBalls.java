package baseball.domain;

import java.util.Arrays;

public class GameBalls {

    public static final int NUMBEROFBALLS = 3;
    protected Ball[] sequence;

    protected GameBalls() {
        this.sequence = new Ball[NUMBEROFBALLS];
    }

    public GameBalls(String userInput) throws IllegalArgumentException {
        int toInteger = convertStringToInteger(userInput);
        int[] numberArray = convertIntegerToNumberArray(toInteger);

        this.sequence = new Ball[NUMBEROFBALLS];
        for (int i = 0; i < NUMBEROFBALLS; i++) {
            this.sequence[i] = new Ball(numberArray[i]);
        }
    }

    public int convertStringToInteger(String userInput) throws IllegalArgumentException {
        if (userInput.length() != NUMBEROFBALLS) {
            throw new IllegalArgumentException(NUMBEROFBALLS + " 자리 숫자를 입력하세요");
        }

        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBEROFBALLS + "자리 숫자를 입력하세요");
        }
    }

    public int[] convertIntegerToNumberArray(int userNumber) throws IllegalArgumentException {
        int[] numbers = new int[NUMBEROFBALLS];
        boolean[] isUsedNumber = new boolean[10];

        for (int i = NUMBEROFBALLS - 1; i >= 0; i--) {
            numbers[i] = userNumber % 10;
            userNumber /= 10;
            if (isUsedNumber[numbers[i]]) {
                throw new IllegalArgumentException("서로 다른 숫자를 입력하세요");
            }
            isUsedNumber[numbers[i]] = true;
        }
        return numbers;
    }

    public Ball getBallByIndex(int index) {
        return this.sequence[index];
    }

    @Override
    public String toString() {
        return "GameBalls{" +
            "sequence=" + Arrays.toString(sequence) +
            '}';
    }
}
