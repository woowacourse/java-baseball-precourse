package baseball.domain.players;

import baseball.domain.constants.ConstantsNumbers;

import java.util.HashSet;
import java.util.Set;

public class Users {

    private int corretCount;
    private static final String NUMBER_REGEX_EXCEPT_ZERO = "[1-9]+";

    public boolean isValidNumber(String userInputMessage) {
        validateNumber(userInputMessage);
        return true;
    }

    private void validateNumber(String userInputMessage) {
        if (userInputMessage.split("").length != ConstantsNumbers.USER_INPUT_LIMIT_LENGTH) {
            throw new IllegalArgumentException();
        }

        if (!isOneToNineRangeNumber(userInputMessage) || !isDuplicated(userInputMessage)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(String userInputMessage) {
        Set<Character> duplicatedCheckSet = new HashSet<>();
        for (char ch : userInputMessage.toCharArray()) {
            duplicatedCheckSet.add(ch);
        }
        return userInputMessage.length() == duplicatedCheckSet.size();
    }

    private boolean isOneToNineRangeNumber(String userInputMessage) {
        corretCount = 0;

        for (int i = 0; i < userInputMessage.length(); i++) {
            isDigitNumber(userInputMessage);
        }

        if (corretCount == ConstantsNumbers.CORRECT_NUMBER) {
            return true;
        }

        return false;
    }

    private boolean isDigitNumber(String userInputMessage) {
        if (userInputMessage.matches(NUMBER_REGEX_EXCEPT_ZERO)) {
            corretCount++;
            return true;
        }
        throw new IllegalArgumentException();
    }
}
