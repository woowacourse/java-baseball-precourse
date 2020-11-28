package baseball;

import java.util.HashSet;

public class NumberConditionChecker {
    private NumberConditionChecker() {
    }

    public static int[] splitNumberToDigits(int number) {
        int[] digits = new int[3];
        for (int index = 2; index >= 0; index--) {
            int digit = number % 10;
            number /= 10;
            digits[index] = digit;
        }
        return digits;
    }

    public static boolean checkZeroInList(int[] numbers) {
        for (int index = 0; index < 3; index++) {
            if (numbers[index] == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkNoOverlapNumber(int[] numbers) {
        HashSet<Integer> digitSet = new HashSet<Integer>();
        for (int index = 0; index < 3; index++) {
            digitSet.add(numbers[index]);
        }
        if (digitSet.size() == numbers.length) {
            return true;
        }
        return false;
    }
}
