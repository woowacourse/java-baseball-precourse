package baseball;

import baseball.game.BaseBallGame;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        final Scanner scanner = new Scanner(System.in);
        BaseBallGame game = new BaseBallGame(scanner);
        game.start();
    }
}
