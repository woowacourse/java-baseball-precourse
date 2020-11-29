package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // 외부에서 플레이어가 게임에 참여한다고 가정하였음
        final Player player = new Player();

        final GameController gameController = new GameController(scanner, player);
        gameController.run();
    }
}
