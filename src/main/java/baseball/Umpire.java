package baseball;

import org.junit.jupiter.api.Assertions;

import constants.HintMessage;
import constants.NumberAttribute;

public class Umpire {
    private static String randomNumber;
    private static int DIGIT_NUMBER;

    Umpire (String number){
        randomNumber = number;
        DIGIT_NUMBER = NumberAttribute.DIGIT_NUMBER.getValue();
    }

    public String judgeRound(final String userNumber){
        int ballCount = isBall(randomNumber, userNumber);
        int strikeCount = isStrike(randomNumber, userNumber);
        Assertions.assertTrue(ballCount <= DIGIT_NUMBER && strikeCount <= DIGIT_NUMBER);
        return getHint(ballCount, strikeCount);
    }

    public int isStrike(String opponentNumber, String userNumber) {
        int strikeCount = 0;
        for (int i = 0; i < DIGIT_NUMBER; i++) {
            if (opponentNumber.charAt(i) == userNumber.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int isBall(String opponentNumber, String userNumber) {
        int ballCount = 0;
        for (int i = 0; i < DIGIT_NUMBER; i++) {
            for (int j = 0; j < DIGIT_NUMBER; j++) {
                if (i != j && opponentNumber.charAt(i) == userNumber.charAt(j)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    public String getHint(final int ballCount, final int strikeCount) {

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
