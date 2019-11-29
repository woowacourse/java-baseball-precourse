import java.util.Arrays;

public class User {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_COUNT = 3;

    public static int[] readNumbers(String input) {
        int[] numbers = input.chars().map(c -> c - '0').toArray();
        if (!checkLength(numbers)) {
            throw new IllegalArgumentException("길이가 3이 아니다.");
        }
        if (!checkRange(numbers)) {
            throw new IllegalArgumentException("1부터 9까지 범위를 벗어난다.");
        }
        if (!checkOverlap(numbers)) {
            throw new IllegalArgumentException("중복된 수가 존재한다.");
        }
        return numbers;
    }

    private static boolean checkLength(int[] numbers) {
        return numbers.length == NUMBER_COUNT;
    }

    private static boolean checkOverlap(int[] numbers) {
        int distinctSize = Arrays.stream(numbers).distinct().toArray().length;
        return distinctSize == NUMBER_COUNT;
    }

    private static boolean inRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    private static boolean checkRange(int[] numbers) {
        return Arrays.stream(numbers).allMatch(User::inRange);
    }
}
