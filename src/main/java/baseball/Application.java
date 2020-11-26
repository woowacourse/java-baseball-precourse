package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumbers;
import baseball.domain.DefaultBaseballNumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        BaseballGame baseballGame = BaseballGame.play(new DefaultBaseballNumbersGenerator());
        while (baseballGame.isPlaying()) {
            BaseballNumbers baseballNumbers = InputView.inputBaseballNumbers(scanner);
            int strikeNumber = baseballGame.countStrike(baseballNumbers);
            int ballNumber = baseballGame.countBall(baseballNumbers);
            OutputView.printHint(strikeNumber, ballNumber);

            if (baseballGame.isCorrectTo(baseballNumbers)) {
                OutputView.printEndGame();
                baseballGame.restart(InputView.inputRestartOrStopRequest(scanner), new DefaultBaseballNumbersGenerator());
            }
        }
    }
}
