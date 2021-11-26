package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.Constant;

import static constant.Constant.*;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Game game = new Game();
        boolean flag;
        do {
            game.gameStart();
            flag = startNewGame();
        } while (flag);
    }

    private static boolean startNewGame() {
        System.out.println(Constant.RESTART_MESSAGE);
        String answer = Console.readLine();

        if (answer.length() > RESTART_ANSWER_LENGTH) {
            throw new IllegalArgumentException(Constant.INPUT_ERROR_INVALID_INPUT);
        }

        if (!answer.equals(RESTART_YES) && !answer.equals(RESTART_NO)) {
            throw new IllegalArgumentException(Constant.INPUT_ERROR_INVALID_INPUT);
        }

        if (answer.equals(RESTART_YES)) {
            return true;
        }
        return false;
    }
}
