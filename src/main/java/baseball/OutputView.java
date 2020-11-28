package baseball;

import baseball.domain.ScoreBoard;

public class OutputView {

    public static final String BALL = "볼 ";

    public static final String STRIKE = "스트라이크";

    public static final String NOTHING = "낫싱";

    public static final String GAME_END =
            "\n" + BaseballGame.BALLS_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printResult(ScoreBoard scoreBoard) {
        System.out.println(getResult(scoreBoard));
    }

    private String getResult(ScoreBoard scoreBoard) {
        StringBuilder stringBuilder = new StringBuilder();

        if (scoreBoard.hasZeroBall() && scoreBoard.hasZeroStrike()) {
            return NOTHING;
        }

        if (!scoreBoard.hasZeroBall()) {
            stringBuilder.append(scoreBoard.getBall()).append(BALL);
        }

        if (!scoreBoard.hasZeroStrike()) {
            stringBuilder.append(scoreBoard.getStrike()).append(STRIKE);
        }

        if (scoreBoard.isAnswer()) {
            stringBuilder.append(GAME_END);
        }

        return stringBuilder.toString();
    }
}
