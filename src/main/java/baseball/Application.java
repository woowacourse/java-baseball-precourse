package baseball;

import baseball.controller.GameController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        GameController gameController = new GameController(scanner);
        gameController.run();

    }

}
