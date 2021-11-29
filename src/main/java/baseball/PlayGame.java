package baseball;

import java.util.HashSet;

import communication.InputManager;
import communication.Text;

import camp.nextstep.edu.missionutils.Randoms;

public class PlayGame {
    private final int ESSENTIAL_NUMBER_LENGTH = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private String computersNumber;
    private String usersNumber;
    private InputManager inputManager = new InputManager();
    private Umpire umpire;

    public PlayGame() {
        assignComputerNumber();
        this.umpire = new Umpire(this.computersNumber);
    }

    private void assignComputerNumber() {
        computersNumber = "";
        HashSet<String> checkOverlap = new HashSet<>();

        for (int i = 0; i < ESSENTIAL_NUMBER_LENGTH; i++) {
            String number = String.valueOf(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));

            if (checkOverlap.contains(number)) {
                i--;
                continue;
            }

            checkOverlap.add(number);
            computersNumber += number;
        }

    }

    private void assignUserNumber() {
        inputManager.requestUserInput();
        this.usersNumber = inputManager.provideUserInput();
    }

    private void playOneSet() {
        assignUserNumber();
        umpire.compareNumbers(usersNumber);
        umpire.reportHint();
    }

    private String restartOrEnd() {
        inputManager.requestUserChoice();

        return inputManager.provideUserChoice();
    }

    private void resetGame(String usersChoice) {

        if (usersChoice.equals(Text.RESTART)) {
            assignComputerNumber();
            umpire = new Umpire(computersNumber);
        } else if (usersChoice.equals(Text.END)) {
            return;
        }

    }

    public void play() {
        String usersChoice = Text.RESTART;

        while (usersChoice.equals(Text.RESTART)) {
            playOneSet();

            if (umpire.isWin()) {
                System.out.println(Text.WIN);
                usersChoice = restartOrEnd();
                resetGame(usersChoice);
            }

        }

    }
}
