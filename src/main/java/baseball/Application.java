package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            Game game = new Game();
            game.game();
            if (!Menu.menu()) {
                break;
            }
        }

    }
}
