package baseball;

import java.util.Scanner;

public class Application {
    /*
    * 숫자 야구게임
    * */

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