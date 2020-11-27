package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        boolean playing = true;
        Game game = new Game();
        
        while (playing) {
            game.generateNewAnswer();
            playing = false;
        }
    }
}
