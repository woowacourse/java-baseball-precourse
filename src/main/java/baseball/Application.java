package baseball;

import controller.GameSystemController;

public class Application {
    public static void main(String[] args) {
        GameSystemController gameController = new GameSystemController();
        gameController.run();
    }
}