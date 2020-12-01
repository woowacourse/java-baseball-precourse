package baseball;

import baseball.service.Game;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int gameStatus = 1;

        while (gameStatus != 2) {
            if (gameStatus == 1) {
                Game.playGame();
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String gameStatusStr = scanner.nextLine();
            gameStatus = Game.checkStatus(gameStatusStr);
        }
    }
}
