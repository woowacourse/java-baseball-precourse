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

    public int numberIndexOf(int index) {
        return computerNumbers.numberIndexOf(index);
    }

    public void initializeNumbersWith(int numbers) {
        computerNumbers.clear();
        computerNumbers.convertIntToList(numbers);
    }

    public List<Integer> getNumbers() {
        return computerNumbers.getNumbers();
    }
}
