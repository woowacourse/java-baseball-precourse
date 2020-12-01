package baseball;

import baseball.domain.game.BaseballGameMachine;
import baseball.domain.game.GameResult;
import baseball.domain.game.GameState;
import baseball.domain.number.BaseballNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        runBaseballGame(inputView);
        scanner.close();
    }

    private static void runBaseballGame(InputView inputView) {
        BaseballGameMachine baseballGameMachine =
                new BaseballGameMachine(BaseballNumbers.generateRandomBaseballNumbers());
        GameState gameState = GameState.initiate();
        while (gameState.isAbleToPlay()) {
            baseballGameMachine = baseballGameMachine.prepareNextTry(gameState);
            BaseballNumbers userBaseballNumbers =
                    BaseballNumbers.generateInputBaseballNumbers(inputView.inputBaseballNumbers());
            GameResult gameResult = baseballGameMachine.calculateGameResult(userBaseballNumbers);
            OutputView.outputGameResult(gameResult);
            gameState = GameState.findGameState(inputView.inputGameState(gameResult));
        }
    }
}
