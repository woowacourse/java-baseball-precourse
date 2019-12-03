package baseball.application;

import baseball.game.Baseball;
import baseball.game.computer.*;
import baseball.game.user.User;
import baseball.game.util.*;

public class GameManager {
    public final static int GAME_SIZE = 3;

    public void run(){
        BallGenerator randomGenerator = new RandomBallGenerator();
        Calculator calculator= new OriginalCalculator();

        BallSystem ballSystem = new BallSystem(randomGenerator, calculator);

        BallGenerator consoleGenerator = new ConsoleBallGenerator();
        User user = new User(consoleGenerator);

        Baseball baseball = new Baseball(ballSystem, user);
        baseball.start();
    }

    public static void main(String[] args) {
        GameManager gm = new GameManager();
        gm.run();
    }
}
