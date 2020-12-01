package baseball;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class NumberConditionChecker {
    private NumberConditionChecker() {
    }

    public static List<Integer> splitNumberToDigits(int number) {
        List<Integer> digits = new ArrayList<Integer>(3);
        for (int index = 0; index < 3; index++) {
            int digit = number % 10;
            number /= 10;
            digits.add(digit);
        }
        return digits;
    }

    public static boolean checkZeroInList(List<Integer> numbers) {
        return numbers.contains(0);
    }

    public static boolean checkOverlapNumber(List<Integer> numbers) {
        HashSet<Integer> digitSet = new HashSet<Integer>(numbers);
        if (digitSet.size() == numbers.size()) {
            return false;
        }
        return true;
    }

    public static boolean checkNumberCondition(int number) {
        List<Integer> numbers = splitNumberToDigits(number);
        return ! (checkZeroInList(numbers) || checkOverlapNumber(numbers));
    }
}
