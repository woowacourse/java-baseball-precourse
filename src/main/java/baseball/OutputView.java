package baseball;

public class OutputView {
    public static void numberInputMessageShow() {
        System.out.print(Constant.NUMBER_INPUT_ALARM_MESSAGE);
    }

    public static void gameEndMessageShow() {
        System.out.println(Constant.GAME_WIN_MESSAGE);
        System.out.println(Constant.GAME_RESTART_OR_EXIT_MESSAGE);
    }
}
