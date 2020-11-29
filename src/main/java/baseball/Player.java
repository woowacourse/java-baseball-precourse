package baseball;

import java.util.List;
import java.util.Scanner;

public class Player {
    private List<Integer> numbers;
    private InputHandler inputHandler;

    public Player(Scanner scanner) {
        this.inputHandler = new InputHandler(scanner);
    }

    public void setNumbers() {
        this.numbers = inputHandler.getNumbers();
    }

    public int getNumber(int index) {
        return this.numbers.get(index);
    }

    public int getNumberSize() {
        return this.numbers.size();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
