package baseball;

import java.util.Scanner;

public class Player {
    private Input keyboard;

    public Player(Scanner scanner) {
        this.keyboard = new Input(scanner);
    }

    public Balls enterNumber() {
        return keyboard.enterNumberInput();
    }

    public boolean enterOrder(){
        return keyboard.enterOrderInput();
    }
}
