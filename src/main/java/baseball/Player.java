package baseball;

import java.util.Scanner;

public class Player {
    private Input keyboard;
    private Balls balls;

    public Player(Scanner scanner) {
        this.keyboard = new Input(scanner);
    }

    public void enterNumber(){
        this.balls = keyboard.enterNumberInput();
    }
}
