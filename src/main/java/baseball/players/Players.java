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

    public User getUser() {
        return user;
    }

    public Computer getComputer() {
        return computer;
    }

    public void clearUserNumbers() {
        user.clearNumbers();
    }
}
