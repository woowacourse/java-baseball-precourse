package domain.player;

import java.util.Arrays;
import java.util.Scanner;

public class Player {
    private boolean isStartingGame = false;
    private String userInput;

    public void startGame(Scanner scanner) {
        isStartingGame = true;
        enterNumberWith(scanner);
    }

    public boolean isStartingGame() {
        return isStartingGame;
    }

    public void enterNumberWith(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        userInput = scanner.next();
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
        if (isNotInteger()) {
            return false;
        }
        if (hasZero()) {
            return false;
        }
        if (isNotValidNumberSize()) {
            return false;
        }
        return true;
    }

    private boolean isNotInteger() {
        try {
            Integer.parseInt(userInput);
            return false;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만을 입력해야 합니다");
        }
    }

    private boolean hasZero() {
        String[] seperatedUserInputByLetter = userInput.split("");
        if (Arrays.asList(seperatedUserInputByLetter).contains("0")) {
            throw new IllegalArgumentException("입력하시는 숫자에는 0이 포함되면 안 됩니다");
        }
        return false;
    }

    private boolean isNotValidNumberSize() {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("입력하시는 숫자는 세 자리여야만 합니다");
        }
        return false;
    }
}
