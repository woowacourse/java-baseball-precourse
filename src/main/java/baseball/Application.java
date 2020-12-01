package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        BaseballGame baseballGame = new BaseballGame(scanner);
        baseballGame.start();
    }
}
