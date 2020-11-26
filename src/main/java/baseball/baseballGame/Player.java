package baseball.baseballGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    Scanner scanner;

    public Player(Scanner scanner) {
        this.scanner = scanner;
    }

    List<Integer> inputNumber(int numLength) {
        System.out.print("숫자를 입력해주세요 : ");

        String userInput = scanner.next();

        if (isInvalidLength(userInput, numLength)) {
            throw new IllegalArgumentException();
        }

        if (isInvalidValue(userInput, numLength)) {    // 1 ~ 9 : valid value
            throw new IllegalArgumentException();
        }

        if (isDuplicated(userInput)) {
            throw new IllegalArgumentException();
        }

        return stringToArray(userInput);
    }

    private boolean isInvalidLength(String userInput, int numLength) {
        if (userInput.length() == numLength) {  // valid input length
            return false;
        }

        return true;
    }

    private boolean isInvalidValue(String userInput, int numLength) {
        char word;

        for (int i=0; i<numLength; i++) {
            word = userInput.charAt(i);

            if (word < '1' || word > '9') {
                return true;
            }
        }

        return false;
    }

    private boolean isDuplicated(String userInput) {
        String[] inputArray = userInput.split("");

        if (inputArray[0].equals(inputArray[1]) || inputArray[0].equals(inputArray[2]) || inputArray[1].equals(inputArray[2])) {
            return true;
        }

        return false;
    }

    private List<Integer> stringToArray(String userInput) {
        String[] stringArray = userInput.split("");
        List<Integer> intArray = new ArrayList<Integer>();

        for (String number : stringArray) {
            intArray.add(Integer.parseInt(number));
        }

        return intArray;
    }
}
