package views;

public class OutputView {
    private static final String ASK_PLAYER_NUMBERS_PROMPT = "숫자를 입력해주세요: ";
    private static final String ASK_REPLAY_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    public static void askPlayerNumbers() {
        System.out.print(ASK_PLAYER_NUMBERS_PROMPT);
    }

    public static void askReplay() {
        System.out.println(ASK_REPLAY_PROMPT);
    }

}
