package baseball;

import baseball.util.GameResultUtil;
import baseball.util.InputUtil;
import baseball.util.OutputUtil;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameManager {
    private Computer computer;

    private GameManager() {
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
        judgeResult(results);
    }

    public boolean judgeResult(List<Integer> results) {
        int strike = results.get(0);

        if (strike == 3) {
            return true;
        } else {
            return false;
        }
    }

}
