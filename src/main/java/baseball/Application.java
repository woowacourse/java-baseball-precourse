package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        boolean playing = true;
        Game game = new Game();
        Player player = new Player(scanner);
        
        while (playing) {
            game.generateNewAnswer();
            player.guessAnswer();
            playing = false;
        }
    }
}
