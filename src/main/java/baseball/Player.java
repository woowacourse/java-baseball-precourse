package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Player {
    static final String INPUT_VALUE_REGEX = "^[1-9]{3}$";
    
    public void guessNumbers() {
        String guessedNumber = inputValue();

        verifyInputValueIsThreeDigitInteger(guessedNumber);

    }

    private void verifyInputValueIsThreeDigitInteger(String guessedNumber) {
        boolean isThreeDigitsInteger = Pattern.matches(INPUT_VALUE_REGEX, guessedNumber);

        if (!isThreeDigitsInteger) {
            throw new IllegalArgumentException("세 자리 정수를 입력하세요.");
        }
    }

    private String inputValue() {
        System.out.print("숫자를 입력해주세요 : ");
        String guessedNumber = Console.readLine();
        return guessedNumber;
    }
}
