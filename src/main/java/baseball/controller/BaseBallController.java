package baseball.controller;

import baseball.model.Balls;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Scanner;

public class BaseBallController {

    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean isEndGaem = false;
        do {
            Balls balls = InputView.inputNumber(scanner);
            OutputView.printResult(balls);
            isEndGaem = OutputView.isEndGame();
        } while (!isEndGaem);

        scanner.close();
    }
}
