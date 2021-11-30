package baseball;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    List<Integer> playerExpectDeck;

    public List<Integer> validatePlayerInput(String[] input) {

        playerExpectDeck = new ArrayList<>();

        checkSize(input);
        validateEachDigit(input);

        return playerExpectDeck;
    }

    public void validateRetryInput(String retryInput) {

        checkRetryOneOrTwo(retryInput);
    }

    private void checkSize(String[] inputFromUser) {

        if (inputFromUser.length != 3) {

            throw new IllegalArgumentException("세 개의 수를 입력해야 합니다.");
        }
    }

    private void validateEachDigit(String[] input) {
        for (int i = 0; i < 3; i++) {

            Integer number = convertToNumber(input[i]);

            checkZero(number);
            checkAlreadyExistNumber(number);

            playerExpectDeck.add(number);
        }
    }

    private Integer convertToNumber(String digit) {

        try {

            return Integer.parseInt(digit);
        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("문자를 입력하였습니다.");
        }
    }

    private void checkZero(Integer num) {
        if (isZero(num)) {

            throw new IllegalArgumentException("0을 입력하였습니다.");
        }
    }

    private boolean isZero(Integer num) {

        return num.equals(0);
    }

    private void checkAlreadyExistNumber(Integer number) {
        if (doesContain(number)) {

            throw new IllegalArgumentException("중복된 수를 입력하였습니다.");
        }
    }

    private boolean doesContain(Integer number) {

        return playerExpectDeck.contains(number);
    }

    private void checkRetryOneOrTwo(String retryInput) {

        if (!isOneOrTwo(retryInput)) {

            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
    }

    private boolean isOneOrTwo(String retryInput) {

        return retryInput.equals("1") || retryInput.equals("2");
    }
}
