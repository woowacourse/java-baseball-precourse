package baseball;

import static util.GameConstant.*;

import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private String guessNumber;

    public int guessNumber() {
        inputValue();
        verifyGuessNumberIsThreeDigitInteger(guessNumber);
        return Integer.parseInt(guessNumber);
    }

    private void verifyGuessNumberIsThreeDigitInteger(String guessedNumber) {
        boolean isThreeDigitsInteger = Pattern.matches(INPUT_VALUE_REGEX, guessedNumber);
        if (!isThreeDigitsInteger) {
            throw new IllegalArgumentException(NOT_THREE_DIGIT_INTEGER_MESSAGE);
        }
    }

    private void inputValue() {
        System.out.print(INPUT_REQUEST_MESSAGE);
        this.guessNumber = Console.readLine();
    }
}
