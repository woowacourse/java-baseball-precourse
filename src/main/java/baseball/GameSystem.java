package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameSystem {

    private static final int SIG_GAME_CONTINUE = 1;
    private static final int SIG_GAME_END = 2;

    private int signal;

    GameSystem() {
        signal = SIG_GAME_CONTINUE;
    }

    public void executeGameSystem() {
        while (signal == SIG_GAME_CONTINUE) {
            playGame();
            determineContinueGame();
        }
    }

    private void playGame() {}
    private void determineContinueGame() {}

    public
}