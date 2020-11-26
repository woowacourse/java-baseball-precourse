package baseball.players;

import baseball.players.numbers.ComputerNumbers;
import java.util.List;

public class Computer {
    private final ComputerNumbers computerNumbers;

    public Computer() {
        this.computerNumbers = new ComputerNumbers();
    }

    public void generateNumber() {
        computerNumbers.clear();
        computerNumbers.generateNumber();
    }

    public List<Integer> getNumbers() {
        return computerNumbers.getNumbers();
    }
}
