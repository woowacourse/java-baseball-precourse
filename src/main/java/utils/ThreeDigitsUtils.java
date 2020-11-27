package utils;

public class ThreeDigitsUtils {
    private ThreeDigitsUtils() {
    }

    public static int nextBaseballNumber() {
        int number = nextRandomInt();
        while (!isBaseballNumber(number)) {
            number = nextRandomInt();
        }
        return number;
    }

    public static boolean isBaseballNumber(int number) {
        if (isInRange(number) && hasDistinctDigits(number)) {
            return true;
        }
        return false;
    }

    private static boolean hasDistinctDigits(int number) {
        int[] array = toIntArrayOfDigits(number);
        if (array[0] == array[1] || array[1] == array[2] || array[2] == array[0]){
            return false;
        }
        return true;
    }

    private static int nextRandomInt() {
        return RandomUtils.nextInt(100, 999);
    }

    private static boolean isInRange(int number) {
        return (100 <= number && number < 1000);
    }

    public static int[] toIntArrayOfDigits(int number) {
        int[] array = new int[3];
        for (int i = 0; i < 3; i++) {
            array[i] = number % 10;
            number /= 10;
        }
        return array;
    }
}
