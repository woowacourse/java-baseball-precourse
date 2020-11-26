package baseball.baseballGame;

import java.util.Scanner;

public class Game {
    private static final int NUM_LENGTH = 3;
    private static final int GAME_START = 1;
    private Scanner scanner;
    private Round round;
    private int exitButton;


    public Game(Scanner scanner) {
        this.scanner = scanner;
        this.exitButton = 1;
    }

    public void start() {
        Player player = new Player(scanner);

        while (exitButton==GAME_START) {
            round = new Round(NUM_LENGTH);
            exitButton = round.start(player);
        }
    }
}
