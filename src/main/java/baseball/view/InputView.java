package baseball.view;

import camp.nextstep.edu.missionutils.Console;


public class InputView {
    private final static String INPUT_MESSAGE = "숫자를 입력해주세요";
    private final static String NEW_GAME_OR_EXIT_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String getUserString() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String getNewGameOrExitNumber() {
        System.out.println(NEW_GAME_OR_EXIT_GAME_MESSAGE);
        return Console.readLine();
    }
}
