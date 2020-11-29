package baseball.domain;

import java.util.Scanner;

public class BaseballGameLauncher {

    public static void play(Scanner scanner){
        BaseballGame baseballGame = new BaseballGame();
        Player player = new Player();

        while(baseballGame.isGameOver()) {
            player.inputBaseballNumbers(scanner);
            baseballGame.compareBaseBallNumbers(player.getBaseballNumbers());
        }
    }
}
