package baseball.model.Referee;

import baseball.constant.Constant;

public class Hint {
    private int ball;
    private int strike;

    public int[] getHint(String playerNumber, String answerNumber) {
        resetCount();
        ballCount(playerNumber, answerNumber);
        strikeCount(playerNumber, answerNumber);
        strikeExceptBall();

        return new int[]{ball, strike};
    }

    public int getStrike() {
        return strike;
    }

    public void resetCount() {
        ball = Constant.BALL_INITIAL_VALUE;
        strike = Constant.STRIKE_INITIAL_VALUE;
    }

    public void ballCount(String playerNumber, String answerNumber) {
        for (int i = 0; i < playerNumber.length(); i++) {
            if (answerNumber.contains(Character.toString(playerNumber.charAt(i)))) {
                ball++;
            }
        }
    }

    public void strikeCount(String playerNumber, String answerNumber) {
        for (char playerNum : playerNumber.toCharArray()) {
            if (answerNumber.indexOf(playerNum) == playerNumber.indexOf(playerNum)) {
                strike++;
            }
        }
    }

    public void strikeExceptBall() {
        ball = ball - strike;
    }
}
