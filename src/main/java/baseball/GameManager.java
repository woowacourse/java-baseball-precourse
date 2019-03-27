package baseball;

import baseball.util.GameResultUtil;
import baseball.util.InputUtil;
import baseball.util.OutputUtil;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameManager {
    private boolean continueGame;
    private Computer computer;

    public boolean isContinueGame() {
        return continueGame;
    }

    private GameManager() {
        this.continueGame = true;
        this.computer = Computer.getInstance();
    }

    private static class GameManagerHolder {
        public static final GameManager GAME_MANAGER_INSTANCE = new GameManager();
    }

    public static GameManager getInstance() {
        return GameManagerHolder.GAME_MANAGER_INSTANCE;
    }

    public void initGame() {
        computer.setNumbers();
        List<Integer> computerNumbers = computer.getComputerNumbers();
        playGame(computerNumbers);
    }

    public void playGame(List<Integer> computerNumbers) {
        List<Integer> userNumbers = InputUtil.getUserNumber();
        List<Integer> results = GameResultUtil.generateResult(userNumbers, computerNumbers);
        OutputUtil.printResult(results);
        continueGame(results);
    }

    public boolean judgeResult(List<Integer> results) {
        int strike = results.get(0);

        if (strike == 3) {
            return true;
        } else {
            return false;
        }
    }

    public void continueGame(List<Integer> results) {
        if (judgeResult(results)) {
            askContinue();
        } else {
            playGame(computer.getComputerNumbers());
        }
    }

    public void askContinue() {
        int answer = InputView.continueNumber();

        if (answer == 1) {
            initGame();
        } else {
            endGame();
        }
    }

    public void endGame() {
        continueGame = false;
        OutputView.printEnd();
    }
}
