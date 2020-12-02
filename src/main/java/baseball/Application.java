package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        BaseBall baseBall = new BaseBall(scanner);
        do {
            baseBall.init();
            baseBall.playGame();
        } while (baseBall.isUserWantContinue());
        scanner.close();
    }
}
