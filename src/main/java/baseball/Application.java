package baseball;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        GameManagement gm = new GameManagement();
        while (!gm.isGameFinished()) {
            gm.playGame(scanner);
            gm.askReGame(scanner);
        }
    }
}
