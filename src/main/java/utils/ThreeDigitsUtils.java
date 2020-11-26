package utils;

public class ThreeDigitsUtils {
    private ThreeDigitsUtils() {
    }

    private static boolean isThreeDigits(int number) {
        return (100 <= number && number < 1000);
    }

    public static boolean isDistinctThreeDigits(int number) {
        if (!isThreeDigits(number)){
            return false;
        }
        int a = number / 100;
        int b = (number % 100) / 10;
        int c = number % 10;
        if ( a != b && b != c && c!= a){
            return true;
        }
        return false;
    }

    public static int generateBaseballNumber() {
        while (true){
            int number = RandomUtils.nextInt(100, 999);
            if (isDistinctThreeDigits(number)){
                return number;
            }
        }
    }

    public static int[] toIntArrayOfDigit(int number) {
        int[] array = new int[3];
        if (!isThreeDigits(number)) {
            return array;
        }
        for (int i = 0; i < 3; i++) {
            array[i] = number % 10;
            number /= 10;
        }
        return array;
    }
}
