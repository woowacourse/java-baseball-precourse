package baseball.players;

import java.util.Scanner;

public class Players {
    private final User user;
    private final Computer computer;

    public Players(Scanner scanner) {
        this.user = new User(scanner);
        this.computer = new Computer();
    }

    public void generateComputerNumber() {
        computer.generateNumber();
    }

    public void clearUserNumbers() {
        user.clearNumbers();
    }

    public int getUserNumberIndexOf(int userIndex) {
        return user.getNumberIndexOf(userIndex);
    }

    public int getComputerNumberIndexOf(int computerIndex) {
        return computer.getComputerNumberIndexOf(computerIndex);
    }

    public void userInput() {
        user.userInput();
    }

    public boolean isUserWantToContinue() {
        return user.isUserWantToContinue();
    }

    public void initializeComputerNumbersWith(int computerNumber) {
        computer.initializeNumbersWith(computerNumber);
    }

    public void initializeUserNumbersWith(String input) {
        user.initializeNumbersWith(input);
    }
}
