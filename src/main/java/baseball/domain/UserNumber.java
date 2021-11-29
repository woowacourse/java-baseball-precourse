package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class UserNumber {
    private ArrayList<Integer> numbers;
    private static final int NUMBER_SIZE = 3;
    private static final char ASCII_ZERO = '0';

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
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요!");
        }
        for (char num : userInput.toCharArray()) {
            if (!Character.isDigit(num)) {
                throw new IllegalArgumentException("숫자를 입력해주세요!");
            } else if (numbers.contains(num - ASCII_ZERO)) {
                throw new IllegalArgumentException("중복되지 않게 숫자를 입력해주세요!");
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
