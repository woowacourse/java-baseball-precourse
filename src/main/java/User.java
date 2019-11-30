import java.util.Scanner;

public class User {
    private static Scanner scanner = new Scanner(System.in);

    public Numbers inputNumbers() {
        return makeNumbersFromInput(getInput());
    }

    private String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input;
        do {
            input = scanner.nextLine().trim();
        } while (!isValidInput(input));
        return input;
    }

    private boolean isValidInput(String input) {
        return consistOfNumbers(input) && isThreeDigits(input);
    }

    private boolean consistOfNumbers(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isThreeDigits(String input) {
        if (input.length() == 3) {
            return true;
        }
        return false;
    }

    private Numbers makeNumbersFromInput(String input) {
        int firstValue = Integer.parseInt(input.substring(0, 1));
        int secondValue = Integer.parseInt(input.substring(1, 2));
        int thirdValue = Integer.parseInt(input.substring(2, 3));
        Numbers numbers = new Numbers(firstValue, secondValue, thirdValue);
        if (!isValidNumbers(numbers)) {
            return inputNumbers();
        }
        return numbers;
    }

    private boolean isValidNumbers(Numbers numbers) {
        return !includeZero(numbers) && !hasDuplicatedNumber(numbers);
    }

    private boolean includeZero(Numbers numbers) {
        return numbers.hasNumber(0);
    }

    private boolean hasDuplicatedNumber(Numbers numbers) {
        return numbers.hasDuplicatedNumber();
    }
}
