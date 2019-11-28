import java.util.Scanner;

public class User {
    private static Scanner scanner = new Scanner(System.in);

    public Numbers inputNumbers() {

        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.nextLine().trim();

        if (!isValidInput(input)) {
            return inputNumbers();
        }

        Numbers numbersFromUser = new Numbers(input.charAt(0), input.charAt(1), input.charAt(2));

        if (!isValidNumber(numbersFromUser)) {
            return inputNumbers();
        }

        return numbersFromUser;
    }

    private boolean isValidInput(String input) {
        if (!consistOfNumbers(input) || !isThreeDigits(input)) {
            return false;
        }
        return true;
    }

    private boolean isValidNumber(Numbers numbersFromUser) {
        if (includeZero(numbersFromUser) && !hasNoDuplicatedNumber(numbersFromUser)) {
            return false;
        }
        return true;
    }

    private boolean consistOfNumbers(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean isThreeDigits(String input) {
        if (input.length() == 3) {
            return true;
        }
        return false;
    }

    private boolean includeZero(Numbers numbersFromUser) {
        if (numbersFromUser.hasNumber(0)) {
            return true;
        }
        return false;
    }

    private boolean hasNoDuplicatedNumber(Numbers numbersFromUser) {
        if (numbersFromUser.hasDuplicatedNumber()) {
            return true;
        }
        return false;
    }
}
