package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
		// 게임 실행
        new Game();
        Game.startGame(scanner);
    }
}
