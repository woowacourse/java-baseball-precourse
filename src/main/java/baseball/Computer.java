package baseball;

import utils.NumberHandleUtils;
import utils.RandomUtils;

public class Computer {
    // CONSTANTS FOR RANDOM NUMBER
    private static final int NUMBER_START_INCLUSIVE = 100;
    private static final int NUMBER_END_INCLUSIVE = 999;

    // CONSTANTS FOR HINT
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    public int answer;

    public Computer() {
        this.answer = Computer.getRandomNum();
    }

    private static int getRandomNum() {
        int randomNum;
        do {
            randomNum = RandomUtils.nextInt(NUMBER_START_INCLUSIVE, NUMBER_END_INCLUSIVE);
        } while (!NumberHandleUtils.isValidNum(randomNum));
        return randomNum;
    }

    private StrikeAndBall countStrikeAndBall(int[] playerNumArray, int[] answerNumArray) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int playerDigitLoc = 0; playerDigitLoc < 3; playerDigitLoc++) {
            int playerDigit = playerNumArray[playerDigitLoc];

            for (int answerDigitLoc = 0; answerDigitLoc < 3; answerDigitLoc++) {
                int answerDigit = answerNumArray[answerDigitLoc];

                strikeCount += isStrike(playerDigit, playerDigitLoc, answerDigit, answerDigitLoc);
                ballCount += isBall(playerDigit, playerDigitLoc, answerDigit, answerDigitLoc);
            }
        }
        return new StrikeAndBall(strikeCount, ballCount);
    }

    private int isStrike(int playerDigit, int playerDigitLoc, int answerDigit, int answerDigitLoc) {
        if (playerDigitLoc == answerDigitLoc && playerDigit == answerDigit) {
            return 1;
        }
        return 0;
    }

    private int isBall(int playerDigit, int playerDigitLoc, int answerDigit, int answerDigitLoc) {
        if (playerDigitLoc != answerDigitLoc && playerDigit == answerDigit) {
            return 1;
        }
        return 0;
    }

    public StrikeAndBall getStrikeAndBall(int playerNum, int answerNum) {
        int[] playerNumArray = NumberHandleUtils.convertIntToArray(playerNum);
        int[] answerNumArray = NumberHandleUtils.convertIntToArray(answerNum);

        return countStrikeAndBall(playerNumArray, answerNumArray);
    }

    public boolean isThreeStrikes(StrikeAndBall thisTurnResult) {
        if (thisTurnResult.getStrike() == 3) {
            return true;
        }
        return false;
    }

    public void giveHint(StrikeAndBall thisTurnResult) {
        int strikeCount = thisTurnResult.getStrike();
        int ballCount = thisTurnResult.getBall();

        if (0 < strikeCount && 0 < ballCount) {
            System.out.println(ballCount + BALL_MESSAGE + " " + strikeCount + STRIKE_MESSAGE);
        } else if (0 < strikeCount && 0 == ballCount) {
            System.out.println(strikeCount + STRIKE_MESSAGE);
        } else if (0 == strikeCount && 0 < ballCount) {
            System.out.println(ballCount + BALL_MESSAGE);
        } else if (0 == strikeCount && 0 == ballCount) {
            System.out.println(NOTHING_MESSAGE);
        }
    }
}
