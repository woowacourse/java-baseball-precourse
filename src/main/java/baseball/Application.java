package baseball;

import baseball.domain.game.BaseballGameMachine;
import baseball.domain.game.GameResult;
import baseball.domain.game.GameState;
import baseball.domain.number.BaseballNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        BaseballGameMachine baseballGameMachine =
                new BaseballGameMachine(BaseballNumbers.generateRandomBaseballNumbers());
        GameState gameState = GameState.KEEP_PLAYING;
        while (gameState.isAbleToPlay()) {
            baseballGameMachine = baseballGameMachine.prepareNextTry(gameState);
            List<Integer> inputBaseballNumbers = InputView.inputBaseballNumbers(scanner);
            BaseballNumbers userBaseballNumbers = BaseballNumbers.generateInputBaseballNumbers(inputBaseballNumbers);
            GameResult gameResult = baseballGameMachine.play(userBaseballNumbers);
            OutputView.outputGameResult(gameResult);
            int signatureValue = InputView.inputGameState(gameResult, scanner);
            gameState = GameState.findGameState(signatureValue);
        }
    }
}
