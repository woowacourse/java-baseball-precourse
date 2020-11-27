package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUtils {

    private final Scanner scanner;

    private InputUtils(final Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputUtils of(final Scanner scanner) {
        return new InputUtils(scanner);
    }

    public int getIntValue() {
        return inputValueToInt(getNextLine());
    }

    public List<Integer> getIntegerList() {
        int number = inputValueToInt(getNextLine());
        return intValueToList(number);
    }

    private String getNextLine() {
        return checkLength(scanner.nextLine());
    }

    public int inputValueToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력 해주세요");
        }
    }

    public List<Integer> intValueToList(int number) {
        List<Integer> lists = new ArrayList<>();
        for (int i = 100; i > 0; i /= 10) {
            lists.add(number / i);
            number %= i;
        }
        return lists;
    }

    public String checkLength(String text) {
        if (text.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력 해주세요");
        }
        return text;
    }
}
