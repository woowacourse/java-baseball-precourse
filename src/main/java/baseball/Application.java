package baseball;

import baseball.data.GameData;
import baseball.engine.GameEngine;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {
        GameEngine gameEngine = new GameEngine();

        do {
            gameEngine.start();
        } while (checkRestart());
    }

    private boolean checkRestart() {
        System.out.println(GameData.GAME_RESTART_MESSAGE);
        String userInput = Console.readLine();

        if (userInput.equals("1")) {
            return true;
        } else if (userInput.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException(userInput);
        }
    }
}
