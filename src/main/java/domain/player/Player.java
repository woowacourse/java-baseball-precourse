package domain.player;

import domain.computer.Computer;
import ui.Input;
import ui.Output;

import java.util.*;

public class Player {
    boolean isStartingGame = true;
    private String userInput;
    String[] seperatedUserInputByLetter;
    Computer computer = new Computer();

    public void startGame(Scanner scanner) {
        while (isStartingGame) {
            playOneGame(scanner);
        }
    }

    private void playOneGame(Scanner scanner) {
        enterNumberWith(scanner);
        if (computer.isCorrectAnswer(seperatedUserInputByLetter)) {
            isStartingGame = checkIfRestartGame(scanner);
        }
    }

    private void enterNumberWith(Scanner scanner) {
        userInput = Input.receiveNumberInput(scanner);
        seperatedUserInputByLetter = userInput.split("");
        if (!isValidEnterNumber()) {
            enterNumberWith(scanner);
        }
    }

    private boolean isValidEnterNumber() {
        try {
            return tryToValidateEnterNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
    }

    private boolean tryToValidateEnterNumber() throws IllegalArgumentException {
        if (isNotInteger() || hasZero() || isNotValidNumberSize() || hasOvelappedNumber()) {
            return false;
        }
        return true;
    }

    private boolean isNotInteger() {
        try {
            Integer.parseInt(userInput);
            return false;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Output.SHOULD_INPUT_ONLY_NUMBER);
        }
    }

    private boolean hasZero() {
        if (Arrays.asList(seperatedUserInputByLetter).contains("0")) {
            throw new IllegalArgumentException(Output.SHOULD_NOT_INCLUDE_ZERO);
        }
        return false;
    }

    private boolean isNotValidNumberSize() {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException(Output.SHOULD_INPUT_THREE_DIGIT);
        }
        return false;
    }

    private boolean hasOvelappedNumber() {
        ArrayList<String> letterArr = new ArrayList<>();
        for (String x : seperatedUserInputByLetter) {
            letterArr.add(x);
        }
        HashSet<String> letterSet = new HashSet<>(letterArr);
        if (letterArr.size() != letterSet.size()) {
            throw new IllegalArgumentException(Output.SHOULD_NOT_CONTAIN_OVERLAPPED);
        }
        return false;
    }

    private boolean checkIfRestartGame(Scanner scanner) {
        int status = Input.receiveRestartGameInput(scanner);
        if (status == 1) {
            computer.resetAnswer();
            return true;
        }
        if (status == 2) {
            return false;
        }
        throw new IllegalArgumentException(Output.SHOULD_INPUT_ONLY_ONE_OR_TWO);
    }
}
