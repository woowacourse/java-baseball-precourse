package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 9;
        final int MAX_LENGTH = 3;

        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean keepPlaying = true;

        while(keepPlaying) {
            Player.playGame(scanner);
            keepPlaying = Game.continueGame();
        }


    }
}
