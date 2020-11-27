package baseball;

import domain.game.BaseballGameMachine;
import domain.game.GameResult;
import domain.game.GameState;
import domain.number.BaseballNumbers;
import view.InputView;
import view.OutputView;

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
