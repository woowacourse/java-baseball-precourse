package domain.player;

import domain.computer.Computer;

import java.util.*;

public class Player {
    private boolean isStartingGame = false;
    private String userInput;
    String[] seperatedUserInputByLetter;
    Computer computer = new Computer();

    public void startGame(Scanner scanner) {
        int status;
        isStartingGame = true;
        while (isStartingGame) {
            enterNumberWith(scanner);
            if (computer.isCorrectAnswer(seperatedUserInputByLetter)) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                status = scanner.nextInt();
                if (status != 1 && status != 2) {
                    throw new IllegalArgumentException("숫자 1 또는 2만 입력하셔야 합니다");
                }
                if (status == 1) {
                    isStartingGame = true;
                    computer.resetAnswer();
                }
                if (status == 2) {
                    isStartingGame = false;
                }
            }
        }
    }

    public boolean isStartingGame() {
        return isStartingGame;
    }

    public void enterNumberWith(Scanner scanner) {
        System.out.print("숫자를 입력해주세요 : ");
        userInput = scanner.next();
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
        if (isNotInteger()) {
            return false;
        }
        if (hasZero()) {
            return false;
        }
        if (isNotValidNumberSize()) {
            return false;
        }
        if (hasOvelappedNumber()) {
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
}
