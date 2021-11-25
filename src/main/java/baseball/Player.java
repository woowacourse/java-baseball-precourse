package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static baseball.PrintStatement.INPUT_REQUEST_MESSAGE;

public class Player {
    static final String INPUT_VALUE_REGEX = "^[1-9]{3}$";
    private String guessNumber;

    public int guessNumber() {
        inputValue();
        verifyGuessNumberIsThreeDigitInteger(guessNumber);
        return Integer.parseInt(guessNumber);
    }

    private void verifyGuessNumberIsThreeDigitInteger(String guessedNumber) {
        boolean isThreeDigitsInteger = Pattern.matches(INPUT_VALUE_REGEX, guessedNumber);

        if (!isThreeDigitsInteger) {
            throw new IllegalArgumentException("세 자리 정수를 입력하세요.");
        }
    }
    private void inputValue() {
        System.out.print(INPUT_REQUEST_MESSAGE);
        this.guessNumber = Console.readLine();
    }
}
