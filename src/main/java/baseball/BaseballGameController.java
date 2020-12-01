package baseball;

import utils.OutputView;

import java.util.Scanner;

import static utils.Constant.*;

public class BaseballGameController {

    private Scanner scanner;
    private BaseballGame baseballGame;

    public BaseballGameController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startGame() {
        do {
            playGame();
        } while (checkRestart());
    }

    private void playGame() {
        baseballGame = new BaseballGame(scanner);
        while (!baseballGame.isGameEnd()) {
            baseballGame.inputPlayerBalls();
            baseballGame.getHint();
        }
    }

    private boolean checkRestart() {

        OutputView.printSelectRestartOrEnd();

        int selectGameRestart = scanner.nextInt();
        if (selectGameRestart == SELECT_GAME_RESTART) {
            return true;
        } else if (selectGameRestart == SELECT_GAME_END) {
            return false;
        } else {
            return checkRestart();
        }
    }

}
