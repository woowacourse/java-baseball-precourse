package baseballtest;

import java.util.Scanner;

import baseball.GameSystem;

public class GameSystemTest {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        GameSystem gameSystem = new GameSystem();
        gameSystem.playGame(scanner);
        gameSystem.printAnswerForTest();
    }
}
