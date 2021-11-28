package baseball.model;

import baseball.constant.Constant;
import baseball.model.Player.Player;
import baseball.model.Player.PlayerNumber;

public class RetryNumber {
    private char retryNumber;

    public RetryNumber(char retryNumber) {
        isCorrectRetryNumber(retryNumber);
        this.retryNumber = retryNumber;
    }

    public char getRetryNumber() {
        return retryNumber;
    }

    public void setRetryNumber(char retryNumber) {
        this.retryNumber = retryNumber;
    }

    public static void isCorrectRetryNumber(char retryNumber) throws IllegalArgumentException {
        if (retryNumber != Constant.GAME_RETRY_NUMBER && retryNumber != Constant.PROGRAM_END_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
