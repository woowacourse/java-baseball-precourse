package baseball;

import baseball.controller.GameController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean gameStatus = true;

        // 플레이어가 3자리 수를 입력한다.
        while (gameStatus) {
            GameController.scanPlayerNumber(scanner);
        }
    }
}
