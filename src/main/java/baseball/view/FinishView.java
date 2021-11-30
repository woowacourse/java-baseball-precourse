package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class FinishView {

    public static final String CORRECT_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String NEW_GAME_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static boolean needMoreGame() {
        System.out.println(CORRECT_ANSWER_MESSAGE);
        System.out.println(NEW_GAME_OR_EXIT_MESSAGE);
        String userInput = Console.readLine();

        if (userInput.equals("1")) {
            return true;
        }

        return false;
    }

}
