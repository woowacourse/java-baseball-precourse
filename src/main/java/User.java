import java.util.Arrays;

public class User {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_COUNT = 3;
    private static final int NEW_GAME = 1;
    private static final int PROGRAM_EXIT = 2;

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

    public static int readMenu(int input) {
        if (input != NEW_GAME && input != PROGRAM_EXIT) {
            throw new IllegalArgumentException("다시 시작 (1) 또는 프로그램 종료 (2)가 아니다.");
        }
        return input;
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
