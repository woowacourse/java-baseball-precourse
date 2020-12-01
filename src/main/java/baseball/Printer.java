package baseball;

public class Printer {
    private static final String BALL_UNIT = "볼";
    private static final String STRIKE_UNIT = "스트라이크";
    private static final String WHITE_SPACE = " ";
    private static final String BLANK_LINE = "\n";
    private static final String ENTER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String NOTHING = "낫싱\n";
    private static final String GAME_END = "개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    public void enterNumber() {
        System.out.print(ENTER_NUMBER);
    }

    private void nothing() {
        System.out.print(NOTHING);
    }

    /**
     * 점수를 넘겨 받아 출력합니다
     * @param ball 볼 점수
     * @param strike 스트라이크 점수
     */
    public void ballAndStrike(int ball, int strike) {
        if ((ball == 0) && (strike == 0)) {
            nothing();
            return;
        }

        if (ball > 0) {
            System.out.print(ball + BALL_UNIT);
        }

        if (ball > 0 && strike > 0) {
            System.out.print(WHITE_SPACE);
        }

        if (strike > 0) {
            System.out.print(strike + STRIKE_UNIT);
        }
        System.out.print(BLANK_LINE);
    }

    public void gameOver(int gameDigit) {
        System.out.print(gameDigit + GAME_END);
    }
}