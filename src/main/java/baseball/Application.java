package baseball;

import baseball.controller.GameController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean gameStatus = true;

        while (gameStatus) {
            GameController.startGame(scanner);

            if (GameController.finishGame(scanner)) {
                break;
            }
        }
    }
}
