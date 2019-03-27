package me.bactoria.baseball.utils;

import me.bactoria.baseball.Constant;

public class IntegerUtils {

    public static boolean containZero(int num) {
        while (num > 0) {
            int curN = num % 10;
            if (curN == 0) return true;
            num /= 10;
        }
        return false;
    }

    public static boolean isNthDigitsNumber(int num) {
        return getLength(num) == Constant.NUMBER_OF_DIGITS;
    }

    private static int getLength(int num) {
        return (int) Math.log10(num) + 1;
    }

    public static boolean isEachDigitUnique(int num) {
        boolean[] visited = new boolean[10];

        while (num > 0) {
            int n = num % 10;
            if (visited[n]) return false;
            else visited[n] = true;
            num /= 10;
        }
        return true;
    }
}
