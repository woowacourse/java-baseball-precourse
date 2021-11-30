package baseball.domain;

import baseball.view.Viewer;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

import static baseball.util.Constant.*;

public class UserNumber {
    private ArrayList<Integer> numbers;

    public UserNumber() {
        numbers = new ArrayList<>();
    }

    public void init() {
        resetUserNumber();
        getUserNumber();
    }

    public void getUserNumber() {
        Viewer.inputNumber();
        String userInput = Console.readLine();
        if (userInput.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_INPUT_LENGTH_MESSAGE);
        }
        for (char num : userInput.toCharArray()) {
            if (!Character.isDigit(num)) {
                throw new IllegalArgumentException(INVALID_INPUT_TYPE_MESSAGE);
            } else if (numbers.contains(num - ASCII_ZERO)) {
                throw new IllegalArgumentException(INVALID_INPUT_DUPLICATED_MESSAGE);
            }
            numbers.add(num - ASCII_ZERO);
        }
    }

    public int getByIndex(int index) {
        return numbers.get(index);
    }

    public void resetUserNumber() {
        numbers.clear();
    }
}
