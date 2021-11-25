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

    private void playGame() {
    }

    private void determineContinueGame() {
        String users_signal = Console.readLine();
        if (users_signal.equals("2"))
            signal = 2;
        try {
            if (!users_signal.equals("1")) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            signal = 2;
        }
    }
}