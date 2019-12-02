package BaseballGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
    private static Scanner scanner = new Scanner(System.in);
    private static final int LENGTH_OF_NUMBERS = 3;
    private static final int LENGTH_OF_RESTART_INPUT = 1;


    public NumbersGroup inputNumbers() {
        try {
            return makeNumbersFromInput(getInput());
        } catch (Exception e) {
            System.out.println("잘못 입력하셨습니다.");
            return inputNumbers();
        }
    }

    private String getInput() throws Exception {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.nextLine().trim();
        validateInput(input, LENGTH_OF_NUMBERS);
        return input;
    }

    private void validateInput(String input, int digits) throws Exception {
        validateIfOnlyNumbers(input);
        validateDigits(input, digits);
    }

    private void validateIfOnlyNumbers(String input) throws Exception {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new Exception("숫자만 입력해주세요.");
        }
    }

    private void validateDigits(String input, int digits) throws Exception {
        if (input.length() != digits) {
            throw new Exception(digits + "자리가 아닙니다.");
        }
    }

    private NumbersGroup makeNumbersFromInput(String input) throws Exception {
        int firstValue = Integer.parseInt(input.substring(0, 1));
        int secondValue = Integer.parseInt(input.substring(1, 2));
        int thirdValue = Integer.parseInt(input.substring(2, 3));
        Map<Integer, Integer> numbers = new HashMap<>();
        numbers.put(firstValue, 1);
        numbers.put(secondValue, 2);
        numbers.put(thirdValue, 3);

        return NumbersGroup.makeNumbersFromInput(numbers);
    }

    public boolean askIfRestart() {
        try {
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = scanner.nextLine().trim();
            validateInput(input, LENGTH_OF_RESTART_INPUT);
            return decideIfRestart(Integer.parseInt(input));
        } catch (Exception e) {
            return askIfRestart();
        }
    }

    private boolean decideIfRestart(int input) throws Exception {
        if (input == 1) {
            return true;
        }

        if (input == 2) {
            return false;
        }

        throw new Exception("잘못 입력하셨습니다.");
    }
}
