package baseball;

import static baseball.Message.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        do {
            BaseballGame newGame = new BaseballGame();

            newGame.gameStart();

        } while (reGame());
    }

    private static boolean reGame() {
        System.out.print(NEW_GAME_MESSAGE);
        String number = readLine();
        checkInputOneTwo(number);
        return NEW_GAME.equals(number);
    }

    private static void checkInputOneTwo(String input) {
        if (!NEW_GAME.equals(input) && !FINISH_GAME.equals(input)) {
            throw new IllegalArgumentException(ERROR);
        }
    }
}
