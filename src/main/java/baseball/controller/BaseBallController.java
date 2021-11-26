package baseball.controller;

import baseball.model.Balls;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.ScannerInputStrategy;

import java.util.Scanner;

public class BaseBallController {

    public void run() {
        boolean isEndGaem = false;
        do {
            Balls balls = InputView.inputNumber(new ScannerInputStrategy());
            OutputView.printResult(balls);
            isEndGaem = OutputView.isEndGame();
        } while (!isEndGaem);
        
    }
}
