package baseball.players;

import baseball.players.numbers.ComputerNumbers;

public class Computer {
    private final ComputerNumbers computerNumbers;

    public Computer() {
        this.computerNumbers = new ComputerNumbers();
    }

    public void generateNumber() {
        computerNumbers.clear();
        computerNumbers.generateNumber();
    }

    public void initializeNumbersWith(int numbers) {
        computerNumbers.clear();
        computerNumbers.convertIntToList(numbers);
        computerNumbers.checkNumbers();
    }

    public int getComputerNumberIndexOf(int computerIndex) {
        return computerNumbers.getNumberIndexOf(computerIndex);
    }
}
