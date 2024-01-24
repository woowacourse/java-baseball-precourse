package baseball.model;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {

    private final Answer answer;

    private boolean isOngoing = true;
    private Command command;

    public Game() {
        this.answer = new Answer();
    }

    public void play() {
        int value = InputView.readNumber();
        Number number = new Number(value);
        Result result = Referee.call(answer, number);
        OutputView.printResult(result);

        if (result.isGameOver()) {
            this.isOngoing = false;
        }
    }

    public boolean isOngoing() {
        return isOngoing;
    }

    public void readCommand() {
        int value = InputView.readCommand();
        command = new Command(value);
    }

    public boolean isReplay() {
        return command.isReplay();
    }
}
