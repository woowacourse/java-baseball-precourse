package utils;

public class ThreeDigitsUtils {
    private ThreeDigitsUtils() {
    }

    private static boolean isDistinctDigit(int number) {
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
            if (isDistinctDigit(number)){
                return number;
            }
        }
    }
}
