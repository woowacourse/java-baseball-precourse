package baseball.domain.players;

public class Users {

    private int corretCount;
    private static final String NUMBER_REGEX_EXCEPT_ZERO = "[1-9]+";
    private static final int USER_INPUT_LIMIT_LENGTH = 3;

    public boolean isValidNumber(String userInputMessage) {

        if (userInputMessage.length() != USER_INPUT_LIMIT_LENGTH) {
            return false;
        }

        if (!isOneToNineRangeNumber(userInputMessage)) {
            return false;
        }

        return true;
    }

    private boolean isOneToNineRangeNumber(String userInputMessage) {
        corretCount = 0;

        for (int i = 0; i < userInputMessage.length(); i++) {
            isDigitNumber(userInputMessage, i);
        }

        if (corretCount == 3) {
            return true;
        }

        return false;
    }

    private boolean isDigitNumber(String userInputMessage, int i) {
        if (userInputMessage.matches(NUMBER_REGEX_EXCEPT_ZERO)) {
            corretCount++;
            return true;
        }
        throw new IllegalArgumentException();
    }

}
