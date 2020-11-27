package baseball;

import java.util.Scanner;

public class Computer {
    private Scanner scanner;
    private Balls balls;

    public Computer(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startGame() {
        this.balls = NumberGenerator.generateNumber();
        Alert.enterNumber();
    }

}
