package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean keepPlaying = true;

        while(keepPlaying) {
            Player.playGame(scanner);
            keepPlaying = Game.continueGame();
        }


    }
}
