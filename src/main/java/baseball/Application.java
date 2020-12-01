package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        new Game(scanner);
		// TODO 구현 진행
        Game.startGame();
    }
}
