import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
    private static Scanner scanner = new Scanner(System.in);
    private static final int SIZE_OF_NUMBERS = 3;


    public NumbersGroup inputNumbers() {
        return makeNumbersFromInput(getInput());
    }

    private String getInput() {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String input = scanner.nextLine().trim();
            validateInput(input);
            return input;
        } catch (Exception e) {
            return getInput();
        }
    }

    private void validateInput(String input) throws Exception {
        validateIfOnlyNumbers(input);
        validateDigits(input);
    }

    private void validateIfOnlyNumbers(String input) throws Exception {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new Exception("숫자만 입력해주세요.");
        }
    }

    private void validateDigits(String input) throws Exception {
        if (input.length() != SIZE_OF_NUMBERS) {
            throw new Exception("3자리가 아닙니다.");
        }
    }

    private NumbersGroup makeNumbersFromInput(String input) {
        int firstValue = Integer.parseInt(input.substring(0, 1));
        int secondValue = Integer.parseInt(input.substring(1, 2));
        int thirdValue = Integer.parseInt(input.substring(2, 3));
        Map<Integer, Integer> numbers = new HashMap<>();
        numbers.put(firstValue, 1);
        numbers.put(secondValue, 2);
        numbers.put(thirdValue, 3);
        return NumbersGroup.makeNumbersGroupFromInput(numbers);
    }
}
