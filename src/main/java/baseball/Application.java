package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        Player player = new Player(scanner, game);
        
        while (player.isPlaying()) {
            game.generateNewAnswer();
            while(!player.isGuessSuccess()) {
                player.guessAnswer();
            }
            player.printSuccess();
            player.askContinue();
        }
    }
}
