package baseball.view;

public class ResultView {

    private static final String GAME_END_MESSAGE = "게임 종료";
    private static final String ALL_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public static void printResult(int ballCount, int strikeCount) {
        StringBuilder sb = new StringBuilder();
        if (ballCount != 0) {
            sb.append(ballCount + BALL + " ");
        }
        if (strikeCount != 0) {
            sb.append(strikeCount + STRIKE + " ");
        }
        if (ballCount == 0 && strikeCount == 0) {
            sb.append(NOTHING + " ");
        }
        System.out.println(sb);

    }

    public static void printResultInfoMessage() {
        System.out.println(ALL_CLEAR_MESSAGE);
    }

    public static void printGameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }
}
