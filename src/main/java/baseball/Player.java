package baseball;

import java.util.List;
import java.util.Scanner;

public class Player {
    private List<Integer> numbers;

    public Player(Scanner scanner) {
        this.numbers = new InputHandler(scanner).get();
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
