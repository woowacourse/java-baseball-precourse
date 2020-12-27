package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        BaseballIO io = new BaseballIO(scanner);
        Baseball baseball = new Baseball();
        BaseballController controller = new BaseballController(baseball, io);

        while (controller.isPlaying()) {
            controller.doGame();
        }
    }
}
