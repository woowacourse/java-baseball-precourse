package baseball;

import java.util.Scanner;

public class GameEmulator {
    static boolean gameCoin = true;

    static void startEmulator() {
        while (gameCoin) {
            GameComputer gameCom = new GameComputer();
            String computerChoice = gameCom.chooseChoice();
            boolean gameOver = false;
            isGameOver(gameOver, computerChoice);
            gameCoin = checkGameCoin();
        }
    }

    static void isGameOver(boolean gameOver, String computerChoice) {
        while (!gameOver) {
            gameOver = GameComputer.startGame(computerChoice);
        }
    }

    static boolean checkGameCoin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int gameCoin = sc.nextInt();
        ExceptionChecker.checkException(gameCoin);
        return gameCoin == 1;
    }
}
