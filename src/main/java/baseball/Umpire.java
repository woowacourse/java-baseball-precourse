package baseball;

import constants.HintMessage;

import constants.NumberAttribute;
import org.junit.jupiter.api.Assertions;

public class Umpire {
    private static String randomNumber;
    private static int DIGIT_NUMBER;

    Umpire (String number){
        randomNumber = number;
        DIGIT_NUMBER = NumberAttribute.DIGIT_NUMBER.getValue();
    }

    public String judgeRound(final String userNumber){
        int ballCount = countBall(randomNumber, userNumber);
        int strikeCount = countStrike(randomNumber, userNumber);
        Assertions.assertTrue(ballCount <= DIGIT_NUMBER && strikeCount <= DIGIT_NUMBER);
        return getHint(ballCount, strikeCount);
    }

    public int countStrike(String opponentNumber, String userNumber) {
        int strikeCount = 0;
        for (int i = 0; i < DIGIT_NUMBER; i++) {
            if (opponentNumber.charAt(i) == userNumber.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBall(String opponentNumber, String userNumber) {
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
