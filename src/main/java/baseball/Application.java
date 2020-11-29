package baseball;

import baseball.controller.BaseballGame;
import baseball.model.Numbers;
import baseball.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        setupInputSystem(scanner);
        BaseballGame baseballGame = BaseballGame.createNewGame(Numbers.createRandomNumbers());
        baseballGame.play();
    }

    public static void setupInputSystem(Scanner scanner) {
        InputView.setScanner(scanner);
    }
}
