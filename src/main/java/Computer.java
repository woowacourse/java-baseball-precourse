import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_COUNT = 3;
    private static final List<Integer> RANGE = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .boxed().collect(Collectors.toList());

    public static int[] createNumbers() {
        Collections.shuffle(RANGE);
        return RANGE.stream()
                .limit(NUMBER_COUNT)
                .mapToInt(i -> i)
                .toArray();
    }

    private static int strikeCount(int[] user, int[] computer) {
        int count = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (user[i] == computer[i]) {
                count++;
            }
        }
        return count;
    }

    private static boolean in(int userNumber, int[] computer) {
        return Arrays.stream(computer).anyMatch(number -> number == userNumber);
    }

    private static int ballCount(int[] user, int[] computer) {
        int count = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (user[i] != computer[i] && in(user[i], computer)) {
                count++;
            }
        }
        return count;
    }

    public static Result compute(int[] user, int[] computer) {
        int strike = strikeCount(user, computer);
        int ball = ballCount(user, computer);
        return Result.of(strike, ball);
    }
}
