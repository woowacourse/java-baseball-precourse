package baseball;

import java.util.List;
import java.util.Scanner;

public class Player {
    private List<Integer> numbers;
    private Scanner scanner;

    public Player(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setNumbers() {
        this.numbers = new InputHandler(this.scanner).getNumbers();
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
