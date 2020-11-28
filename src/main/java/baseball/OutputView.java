package baseball;

import baseball.domain.Judgment;
import baseball.domain.ScoreBoard;

public class OutputView {

    public static final String GAME_END =
            "\n" + BaseballGame.BALLS_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printResult(ScoreBoard scoreBoard) {
        System.out.println(getResult(scoreBoard));
    }

    public String getResult(ScoreBoard scoreBoard) {
        StringBuilder stringBuilder = new StringBuilder();

        if (scoreBoard.hasZeroBall() && scoreBoard.hasZeroStrike()) {
            return Judgment.NOTHING.getMessage();
        }

        if (!scoreBoard.hasZeroBall()) {
            stringBuilder.append(scoreBoard.getBall()).append(Judgment.BALL.getMessage());
        }

        if (!scoreBoard.hasZeroStrike()) {
            stringBuilder.append(scoreBoard.getStrike()).append(Judgment.STRIKE.getMessage());
        }

        if (scoreBoard.isAnswer()) {
            stringBuilder.append(GAME_END);
        }

        return stringBuilder.toString();
    }
}
