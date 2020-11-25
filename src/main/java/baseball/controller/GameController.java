package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Numbers;
import baseball.view.InputView;

import java.util.Scanner;

public class GameController {
    public void run(Scanner scanner){
        startGame(scanner);
    }

    private void startGame(Scanner scanner) {
        String threeNumbers = InputView.getThreeNumbers(scanner);
        char[] validNumbers = Numbers.isValidNumbers(threeNumbers);
    }
}
