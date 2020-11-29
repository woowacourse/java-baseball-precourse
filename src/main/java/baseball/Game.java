package baseball;

import java.util.Scanner;

public class Game {
    private RandomNumbers randomNumbers;
    private Player player;
    private InputHandler inputHandler;
    private Result result;

    public Game(Scanner scanner) {
        this.randomNumbers = new RandomNumbers();
        this.player = new Player(scanner);
        this.inputHandler = new InputHandler(scanner);
    }

    public void start() {
        while (true) {
            init();
            if (this.inputHandler.restart()) {
                start();
            }
            break;
        }
    }

    private void init() {
        this.randomNumbers.setNumbers();
        turn();
    }

    private void turn() {
        while (true) {
            this.player.setNumbers();
            this.result = new Result(this.randomNumbers, this.player);
            System.out.println(this.result);
            if (stop()) {
                break;
            };
        }
    }

    private boolean stop() {
        return this.result.terminated();
    }
}
