package baseball.model;

import baseball.constant.Constant;

public class Referee {
    public int[] getHint(String playerNumber, String answerNumber){

        int ballCount = CountingBall(playerNumber, answerNumber);
        int strikeCount = CountingStrike(playerNumber, answerNumber);

        return new int[]{ballCount - strikeCount, strikeCount};
    }

    public static int CountingBall(String playerNumber, String answerNumber) {
        int ball = Constant.BALL_INITIAL_VALUE;

        for (int i = 0; i < playerNumber.length(); i++) {
            if (answerNumber.contains(Character.toString(playerNumber.charAt(i)))) {
                ball += 1;
            }
        }
        return ball;
    }

    public static int CountingStrike(String playerNumber, String answerNumber) {
        int strike = Constant.STRIKE_INITIAL_VALUE;

        for (char userNum : playerNumber.toCharArray()) {
            if (answerNumber.indexOf(userNum) == playerNumber.indexOf(userNum)) {
                strike += 1;
            }
        }
        return strike;
    }
}
