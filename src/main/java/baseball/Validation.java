package baseball;

import static baseball.Constants.*;

public class Validation {

    public void isValidInput() {
        if (userNum.length() != DIGIT) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < DIGIT; i++) {
            inRange(i);
            noOverlap(i);
        }
    }

    private void inRange(int i) {
        if (userNum.charAt(i) < '1' || userNum.charAt(i) > '9') {
            throw new IllegalArgumentException();
        }
    }

    private void noOverlap(int i) {
        for (int j = i + 1; j < DIGIT; j++) {
            if (userNum.charAt(i) == userNum.charAt(j)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
