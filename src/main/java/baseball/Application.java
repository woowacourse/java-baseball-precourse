package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        boolean playing = true;
        Game game = new Game();
        Player player = new Player(scanner, game);
        
        while (playing) {
            game.generateNewAnswer();
            while(!player.isGuessSuccess()) {
                player.guessAnswer();
            }
            player.printSuccess();
            playing = false;
        }
    }
}
