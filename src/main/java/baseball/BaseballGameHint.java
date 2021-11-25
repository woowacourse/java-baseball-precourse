package baseball;

import java.util.List;

public class BaseballGameHint {

    private static final int BASEBALL_NUMBER_LENGTH = 3;
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    private List<Integer> computer;
    private List<Integer> player;
    private int ball;
    private int strike;

    public BaseballGameHint() {
        this.ball = 0;
        this.strike = 0;
    }

    public String generateHint(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        computer = computerNumbers;
        player = playerNumbers;

        for (int i = 0; i < BASEBALL_NUMBER_LENGTH; i++) {
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

    public String printHint() {
        StringBuilder hint = new StringBuilder();

        if (ball == 0 && strike == 0) {
            hint.append(NOTHING);
        }

        if (ball != 0) {
            hint
                    .append(ball)
                    .append(BALL);
        }

        if (strike != 0) {
            if (hint.length() != 0) {
                hint.append(" ");
            }

            hint
                    .append(strike)
                    .append(STRIKE);
        }

        return hint.toString();
    }
}
