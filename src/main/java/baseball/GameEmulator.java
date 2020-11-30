package baseball;

import java.util.Scanner;

public class GameEmulator {
    static boolean gameCoin = true;

    static void startEmulator() {
        while (gameCoin) {
            new GameComputer();
            gameCoin = checkGameCoin();
        }
    }

    static boolean checkGameCoin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String gameCoin = sc.nextLine();

        while(ExceptionChecker.checkCoinException(gameCoin)) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameCoin = sc.nextLine();
        }
        
        return gameCoin.equals("1");
    }
}
