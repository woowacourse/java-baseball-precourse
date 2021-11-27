package baseball;

import baseball.controller.GameHandler;

public class Application {
    private static final int PROGRAM_EXIT = 2;
    private static final GameHandler gameHandler = GameHandler.getInstance();

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        while (true) {
            int mode = gameHandler.start();
            if (mode == PROGRAM_EXIT) {
                break;
            }
        }
    }
}
