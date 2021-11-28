package baseball.domain;

import java.util.Arrays;

public class GameBalls {

    public static final int NUMBEROFBALLS = 3;
    private Ball[] sequence;

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

    public int[] convertIntegerToNumberArray(int userNumber) {
        int[] numbers = new int[NUMBEROFBALLS];

        for (int i = NUMBEROFBALLS - 1; i >= 0; i--) {
            numbers[i] = userNumber % 10;
            userNumber /= 10;
        }
        return numbers;
    }

    @Override
    public String toString() {
        return "GameBalls{" +
            "sequence=" + Arrays.toString(sequence) +
            '}';
    }
}
