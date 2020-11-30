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
        int gameCoin = sc.nextInt();

        while(ExceptionChecker.checkException(gameCoin)) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameCoin = sc.nextInt();
        }
        
        return gameCoin == 1;
    }
}
