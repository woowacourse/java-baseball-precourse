package baseball;

import java.util.Scanner;

public class Application {
    public static final int NUMBER_LENGTH = 3;
    public static final int RESTART_CODE = 1;
    public static final int END_CODE = 2;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        int restartGame = 1;
        while (restartGame == RESTART_CODE) {
            restartGame = GameController.playGame(scanner);
        }
    }
}