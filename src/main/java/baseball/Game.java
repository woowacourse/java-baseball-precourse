package baseball;

import java.util.Scanner;
import views.OutputView;

public class Game {
    private Scanner userInput;

    public Game(Scanner userInput) {
        this.userInput = userInput;
    }

    public void play() {
        initialize();
        proceedRound();
    }

    private void initialize() {

    }

    private void proceedRound() {
        OutputView.askPlayerNumbers();
    }
}
