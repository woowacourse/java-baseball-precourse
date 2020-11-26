package baseball;

import java.util.Scanner;

public class Game {

    private final GameSystem gameSystem;

    public Game(Scanner scanner){
        gameSystem = new GameSystem(scanner);
    }

    public void gameStart(){
        int targetValue = gameSystem.getRandomValue();
        boolean flag = true;
        do{
            int input = gameSystem.valueInsert();
            if (gameSystem.isCorrect(targetValue, input)) {
                flag = gameSystem.gameContinue();
                targetValue = gameSystem.getRandomValue();
            } else {
                gameSystem.getHint(targetValue, input);
            }
        } while(flag);
    }
}
