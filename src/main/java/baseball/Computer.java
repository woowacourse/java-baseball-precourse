package baseball;

import java.util.Scanner;

public class Computer {
    private Balls balls;
    private Player player;

    public Computer(Scanner scanner) {
        this.player = new Player(scanner);
    }

    public void startGame() {
        this.balls = NumberGenerator.generateNumber();
        Alert.enterNumber();

    }

}
