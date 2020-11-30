package baseball.service;

import baseball.service.ui.Input;
import baseball.service.ui.Output;

import java.util.Scanner;

public class BaseballGame {
    private Input input;
    private Output output;
    private Hint hint;

    public BaseballGame(Scanner scanner) {
        input = new Input(scanner);
        output = new Output();
        hint = new Hint();
    }

    public void start() {
        do {
            startRound();
        } while(restart());
    }

    private void startRound() {
        hint.createAnswer();
        String hintAnswer;

        do {
            output.inputNumber();

            int[] userInput = input.inputNumber();
            hintAnswer = hint.ask(userInput);

            output.showResult(hintAnswer);
        } while (!hint.isitCorrect());

        endRound();
    }

    private void endRound() {
        output.correctAnswer();
    }

    private boolean restart() {
        output.askRestart();

        if (input.askRestart()) {
            return true;
        }

        return false;
    }
}
