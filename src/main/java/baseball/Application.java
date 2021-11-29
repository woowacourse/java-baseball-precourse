package baseball;

import static baseball.view.InputView.inputNumbers;
import static baseball.view.ResultView.viewGameResult;

import baseball.domain.computer.Computer;
import baseball.domain.computer.GameResult;
import baseball.domain.number.BaseBallNumbers;

public class Application {
    public static void main(String[] args) {
        Computer computer = Computer.init();
        GameResult gameResult = GameResult.init();

        while (!computer.isFinishedGame()) {
            BaseBallNumbers userBaseBallNumbers = BaseBallNumbers.createByIntegerNumbers(inputNumbers());
            gameResult = computer.calculateBaseBallGame(userBaseBallNumbers);
            viewGameResult(gameResult);
            computer.refresh();
        }
    }
}
