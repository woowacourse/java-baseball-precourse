import baseballgame.*;

/**
 * @author KSKIM
 * @version 1.0.0
 * @since 2019-11-28
 */
public class Main {
    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        BaseballGame baseballGame = new BaseballGame(randomNumberGenerator);

        do {
            baseballGame.run();
        } while (baseballGame.restart());
    }
}
