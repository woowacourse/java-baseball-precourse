package baseball.application;

import baseball.game.Baseball;
import baseball.game.computer.*;
import baseball.game.user.User;
import baseball.game.util.*;

public class GameManager {
    public final static int GAME_SIZE = 3;

    public void run(){
        BallGenerator randomGenerator = new RandomBallGenerator();
        Generator generator = new Generator(randomGenerator);

        Calculator calculator= new OriginalCalculator();

        BallSystem ballSystem = new BallSystem(generator, calculator);

        BallGenerator consoleGenerator = new ConsoleBallGenerator();
        User user = new User(consoleGenerator);

        Baseball baseball = new Baseball(ballSystem, user);
        baseball.start();
    }

    public static void main() {
        GameManager gm = new GameManager();
        gm.run();
    }
}
