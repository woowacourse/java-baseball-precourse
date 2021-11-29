package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class GameBalls {

    public static final int NUMBEROFBALLS = 3;
    private Ball[] sequence;

    public GameBalls() {
        this.sequence = new Ball[NUMBEROFBALLS];
        boolean[] isUsedNumber = new boolean[10];

        int index = 0;
        while (index != NUMBEROFBALLS) {
            int pickNumberInRange = Randoms.pickNumberInRange(1, 9);
            if (isUsedNumber[pickNumberInRange]) {
                continue;
            }

            this.sequence[index] = new Ball(pickNumberInRange);
            isUsedNumber[pickNumberInRange] = true;
            index++;
        }
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

    @Override
    public String toString() {
        return "GameBalls{" +
            "sequence=" + Arrays.toString(sequence) +
            '}';
    }
}
