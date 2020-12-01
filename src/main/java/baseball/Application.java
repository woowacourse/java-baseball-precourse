package baseball;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        new BaseBallGame(scanner).play();
        scanner.close();
    }
}
