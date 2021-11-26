package baseball;

import static baseball.Constants.*;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final Computer computer;
    private final Validation validation;

    public Game(Computer computer, Validation validation) {
        this.computer = computer;
        this.validation = validation;
    }

    public void startGame() {
        while (true) {
            startRound();

            if (!restart()) {
                return;
            }
        }
    }

    private void startRound() {
        randNum = computer.makeRandNum();

        while (true) {
            System.out.print(INPUT_MESSAGE);
            userNum = Console.readLine();
            validation.isValidInput();
            String result = computer.compareNumbs();
            System.out.println(result);
            if (result.equals(ANSWER)) {
                System.out.println(CLEAR_MESSAGE);
                return;
            }
        }
    }

    private boolean restart() {
        System.out.println(RESTART_MESSAGE);
        String input = Console.readLine();

        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
