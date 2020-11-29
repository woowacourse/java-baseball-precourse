package utils;

import java.util.HashSet;
import java.util.Set;

public class NumberHandleUtils {
    public static int[] convertIntToArray(int num) {
        int[] thisArray = new int[3];
        for (int i = 2; i > -1; i--) {
            thisArray[i] = num % 10;
            num /= 10;
        }
        return thisArray;
    }

    public static boolean isValidNum(int candidateNum) {
        Set<Integer> previousDigitSet = new HashSet<>();

        // all 3 digits MUST BE different and NOT BE 0
        int[] candidateArray = convertIntToArray(candidateNum);
        for (int candidateDigit : candidateArray) {
            if (previousDigitSet.contains(candidateDigit) || candidateDigit == 0) {
                return false;
            }
            previousDigitSet.add(candidateDigit);
        }
        return true;
    }
}
