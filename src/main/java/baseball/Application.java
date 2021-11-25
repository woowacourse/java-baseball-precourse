package baseball;

import static util.GameConstant.*;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new GamePlayer(), new GameProvider());
        baseballGame.run();
    }

}
