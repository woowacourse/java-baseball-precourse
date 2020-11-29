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

    public List<Integer> getIntegers() {
        System.out.print("숫자를 입력해주세요 : ");
        int number = stringToInt(getNextLine());
        return intToList(number);
    }

    public String getNextLine() {
        String inputValue = scanner.nextLine();
        validateLength(inputValue);
        return inputValue;
    }

    public int getContinueOrNot() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int inputValue = stringToInt(scanner.nextLine());
        validateContinueOrNot(inputValue);
        return inputValue;
    }

    public int stringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력 해주세요");
        }
    }

    public List<Integer> intToList(int number) {
        List<Integer> lists = new ArrayList<>();
        for (int i = 100; i > 0; i /= 10) {
            lists.add(number / i);
            number %= i;
        }
        return lists;
    }

    public void validateLength(String text) {
        if (text.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력 해주세요");
        }
    }

    private void validateContinueOrNot(int number) {
        if (number < 1 || number > 2) {
            throw new IllegalArgumentException("1또는 2를 입력해주세요");
        }
    }
}
