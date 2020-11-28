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

    public List<Integer> getIntegerList() {
        System.out.print("숫자를 입력해주세요 : ");
        int number = inputValueToInt(getNextLine());
        return intValueToList(number);
    }

    private String getNextLine() {
        return checkLength(scanner.nextLine());
    }

    public int getContinueOrNot() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return checkContinueOrNot(inputValueToInt(scanner.nextLine()));
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

    public int checkContinueOrNot(int number) {
        if (number < 1 || number > 2) {
            throw new IllegalArgumentException("1또는 2를 입력해주세요");
        }
        return number;
    }
}
