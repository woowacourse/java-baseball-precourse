package baseball;

import java.util.List;

public class BaseballGameHint {

    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    private List<Integer> computer;
    private List<Integer> player;
    private int ball;
    private int strike;

    public String generateHint(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        computer = computerNumbers;
        player = playerNumbers;
        ball = 0;
        strike = 0;

        for (int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++) {
            checkBall(i);
        }
        return printHint();
    }

    private void checkBall(int index) {
        int number = player.get(index);

        if (computer.contains(number)) {
            if (!checkStrike(number, index)) {
                ball++;
            }
        }
    }

    private boolean checkStrike(int playerNumber, int index) {
        int computerNumber = computer.get(index);

        if (computerNumber == playerNumber) {
            strike++;
            return true;
        }
        return false;
    }

    private String printHint() {
        StringBuilder hint = new StringBuilder();

        if (ball == 0 && strike == 0) {
            hint.append(NOTHING_MESSAGE);
        }
        if (ball != 0) {
            hint.append(ball).append(BALL_MESSAGE);
        }
        if (strike != 0) {
            if (hint.length() != 0) {
                hint.append(" ");
            }
            hint.append(strike).append(STRIKE_MESSAGE);
        }
        return hint.toString();
    }
}
