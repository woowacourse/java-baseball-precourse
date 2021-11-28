package baseball;

import org.junit.jupiter.api.Assertions;

import constants.HintMessage;
import constants.NumberAttribute;

public class Umpire {

    private static String randomNumber;

    Umpire (String number){

        randomNumber = number;
    }

    public String judgeRound(final String userNumber){

        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < NumberAttribute.DIGIT_NUMBER.getValue(); i++) {
            char digit = userNumber.charAt(i);
            if (isStrike(digit, i)) {
                strikeCount++;
            } else if (isBall(digit)) {
                ballCount++;
            }
        }

        Assertions.assertTrue(ballCount <= NumberAttribute.DIGIT_NUMBER.getValue()
                && strikeCount <= NumberAttribute.DIGIT_NUMBER.getValue());

        return getHint(ballCount, strikeCount);
    }


    private boolean isStrike(final char digit, final int pos) {

        return randomNumber.charAt(pos) == digit;
    }

    private boolean isBall(final char digit) {

        for (int i = 0; i < NumberAttribute.DIGIT_NUMBER.getValue(); i++) {
            if (randomNumber.charAt(i) == digit) {
                return true;
            }
        }
        return false;
    }

    private String getHint(final int ballCount, final int strikeCount) {

        if (ballCount == 0 && strikeCount == 0) {
            return HintMessage.NOTHING.getHint();
        } else if (ballCount == 0) {
            return strikeCount + HintMessage.STRIKE.getHint();
        } else if (strikeCount == 0) {
            return ballCount + HintMessage.BALL.getHint();
        }
        return ballCount + HintMessage.BALL.getHint() + " " + strikeCount + HintMessage.STRIKE.getHint();
    }
}