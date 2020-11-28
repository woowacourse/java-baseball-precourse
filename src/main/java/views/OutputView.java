package views;

public class OutputView {

    private static final String ASK_PLAYER_NUMBERS_PROMPT = "숫자를 입력해주세요: ";
    private static final String BALL_COUNT_PROMPT = "%d볼 ";
    private static final String STRIKE_COUNT_PROMPT = "%d스트라이크 ";
    private static final String NOTHING_PROMPT = "낫싱";
    private static final String WIN_PROMPT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_REPLAY_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    public static void askPlayerNumbers() {
        System.out.print(ASK_PLAYER_NUMBERS_PROMPT);
    }

    public static void printStatus(long ballCount, long strikeCount) {
        if (ballCount > 0) {
            System.out.printf(BALL_COUNT_PROMPT, ballCount);
        }
        if (strikeCount > 0) {
            System.out.printf(STRIKE_COUNT_PROMPT, strikeCount);
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print(NOTHING_PROMPT);
        }
        System.out.println();
    }

    public static void congratulateWin() {
        System.out.println(WIN_PROMPT);
    }

    public static void askReplay() {
        System.out.println(ASK_REPLAY_PROMPT);
    }

}
