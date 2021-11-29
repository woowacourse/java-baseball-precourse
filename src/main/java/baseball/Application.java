package baseball;

import static baseball.view.InputView.inputGameStateCommand;
import static baseball.view.InputView.inputNumbers;
import static baseball.view.ResultView.viewGameResult;

import baseball.domain.computer.Computer;
import baseball.domain.computer.GameResult;
import baseball.domain.number.BaseBallNumbers;

public class Application {

    public static void main(String[] args) {
        Computer computer = Computer.init();
        gameStart(computer);
    }

    private static void gameStart(Computer computer) {
        while (!computer.isFinishedGame()) {
            computer = computer.refresh();
            BaseBallNumbers userBaseBallNumbers = BaseBallNumbers.createByIntegerNumbers(inputNumbers());
            GameResult gameResult = computer.calculateBaseBallGame(userBaseBallNumbers);
            viewGameResult(gameResult);
            computer.changeGameState(inputGameStateCommand(gameResult));
        }
    }
}
