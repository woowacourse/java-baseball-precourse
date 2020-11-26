package baseball.baseballGame;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Player {
    Scanner scanner;

    public Player(Scanner scanner) {
        this.scanner = scanner;
    }

    int inputExitButton(){
        String response = scanner.next();

        if (response.equals("1") && response.equals("2")) {
           throw new IllegalArgumentException();
       }

       return Integer.parseInt(response);
    }

    List<Integer> inputNumber(int numLength) {
        System.out.print("숫자를 입력해주세요 : ");

        String userInput = scanner.next();

        if (isInvalidLength(userInput, numLength)) {    // valid length : 3
            throw new IllegalArgumentException();
        }

        if (isInvalidValue(userInput, numLength)) {     // valid number : 1 ~ 9
            throw new IllegalArgumentException();
        }

        if (isDuplicated(userInput)) {
            throw new IllegalArgumentException();
        }

        return stringToArray(userInput);
    }

    private boolean isInvalidLength(String userInput, int numLength) {
        if (userInput.length() == numLength) {
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
        String[] inputStringArray = userInput.split("");
        List<Integer> inputIntArray = new ArrayList<Integer>();

        for (String number : inputStringArray) {
            inputIntArray.add(Integer.parseInt(number));
        }

        return inputIntArray;
    }
}
