package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private final Scanner scanner;
    private static final String WRONG_INPUT = "잘못된 입력입니다.";
    private static final String GET_INPUT = "숫자를 입력해주세요 : ";
    private static final String GAME_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    ArrayList<Integer> inputNumber = null;

    public Player(Scanner scanner) {
        this.scanner = scanner;
    }

    public ArrayList<Integer> getInputNumber() {
        readInputNumber();
        return inputNumber;
    }

    public boolean getIfContinue() {
        return readIfContinue() == 1;
    }

    private int readInputNumber() {
        boolean isValid;
        int number;
        while (true) {
            System.out.print(GET_INPUT);
            number = readFromKeyboard();
            isValid = checkDigit(number);
            if (isValid) {
                break;
            } else {
                System.out.println(WRONG_INPUT);
            }
        }

        return number;
    }

    private int readIfContinue() {
        boolean isValid;
        int number;
        while (true) {
            System.out.println(GAME_RESTART);
            number = readFromKeyboard();
            isValid = checkValidInput(number);
            if (isValid) {
                break;
            } else {
                System.out.println(WRONG_INPUT);
            }
        }

        return number;
    }

    private int readFromKeyboard() throws IllegalArgumentException {
        String input;
        int num;
        try {
            input = scanner.nextLine();
            num = checkIfNumber(input);
        } catch (IllegalArgumentException e) {
            return -1;
        }

        return num;
    }

    private int checkIfNumber(String input) {
        for (int digit = 0; digit < input.length(); digit++) {
            if (!Character.isDigit(input.charAt(digit))) {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
        }

        return Integer.parseInt(input);
    }

    private boolean checkDigit(int checkIfNumber) {
        int numberLen = (int)(Math.log10(checkIfNumber) + 1);
        if (numberLen == 3) {
            return parseInput(checkIfNumber);
        }

        return false;
    }

    private boolean parseInput(int rawNumber) {
        ArrayList<Integer> parsedNumber = new ArrayList<>();

        for (int digit = 0; digit < 3; digit++) {
            int unitNum = rawNumber % 10;
            rawNumber = rawNumber / 10;
            if (!checkIfRepeat(parsedNumber, unitNum)) {
                parsedNumber.add(0, unitNum);
            } else {
                return false;
            }
        }

        inputNumber = parsedNumber;
        return true;
    }

    private boolean checkIfRepeat(ArrayList<Integer> numList, int checkIfNumber) {
        return numList.contains(checkIfNumber);
    }

    private boolean checkValidInput(int number) {
        return number == 1 || number == 2;
    }
}
