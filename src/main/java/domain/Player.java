package domain;

import ui.Input;

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
            throw new IllegalArgumentException("숫자만을 입력해야 합니다.");
        }
    }

    private boolean hasZero() {
        if (Arrays.asList(seperatedUserInputByLetter).contains(ZERO_STRING)) {
            throw new IllegalArgumentException("입력하시는 숫자에는 0이 포함되면 안 됩니다.");
        }
        return false;
    }

    private boolean isNotValidNumberSize() {
        if (userInput.length() != VALID_NUMBER_SIZE) {
            throw new IllegalArgumentException("3자리의 수만 입력해야 합니다.");
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
            throw new IllegalArgumentException("세 자리의 숫자에서 각 자리의 숫자에 중복된 숫자가 포함되면 안 됩니다");
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
        throw new IllegalArgumentException("숫자 1 또는 2만 입력하셔야 합니다");
    }
}
