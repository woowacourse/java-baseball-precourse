package baseball;

import service.GameStarter;

public class Application {

    public static void main(String[] args) {
        GameStarter gameStarter = new GameStarter();
        gameStarter.start();
    }

}
