package baseball;

public class NumberConditionChecker {
    private NumberConditionChecker() {
    }

    public static int[] splitNumberToDigits(int number){
        int[] digits = new int[3];
        for (int index = 2; index >= 0; index--) {
            int digit = number % 10;
            number /= 10;
            digits[index] = digit;
        }
        return digits;
    }
}
