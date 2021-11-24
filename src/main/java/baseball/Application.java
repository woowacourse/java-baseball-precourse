package baseball;

import static baseball.constants.GameConstants.GameOverInput.*;

import baseball.domain.Computer;
import baseball.domain.Game;

public class Application {
    public static void main(String[] args) {
        runGameLoop();
    }

    private static void runGameLoop(){
        Game game = new Game();
        while(true){
            int userGameSelection = game.runGameOnce();
            if(userGameSelection == RESTART.getNumber())
                game.setComputer(new Computer());
            if(userGameSelection == STOP.getNumber())
                break;
        }
    }
}
