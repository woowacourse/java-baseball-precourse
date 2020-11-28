package domain.player;

import domain.computer.Computer;
import ui.Input;
import ui.Output;

import java.util.*;

public class Player {
    private static final int RESTART_GAME = 1;
    private static final int EXIT_GAME = 2;
    private static final int VALID_NUMBER_SIZE = 3;
    private static final String ZERO_STRING = "0";
    private boolean isStartingGame = true;
    private String userInput;
    private String[] seperatedUserInputByLetter;
    private Computer computer = new Computer();


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
        if (Arrays.asList(seperatedUserInputByLetter).contains(ZERO_STRING)) {
            throw new IllegalArgumentException(Output.SHOULD_NOT_INCLUDE_ZERO);
        }
        return false;
    }

    private boolean isNotValidNumberSize() {
        if (userInput.length() != VALID_NUMBER_SIZE) {
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
        if (status == RESTART_GAME) {
            computer.resetAnswer();
            return true;
        }
        if (status == EXIT_GAME) {
            return false;
        }
        throw new IllegalArgumentException(Output.SHOULD_INPUT_ONLY_ONE_OR_TWO);
    }
}
