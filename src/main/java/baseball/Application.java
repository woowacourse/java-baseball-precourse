package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
//        NumberGenerator generator = new NumberGenerator();
//        List<Integer> numbers = generator.createRandomNumbers();
//        System.out.println(numbers);

        Judgement judgement = new Judgement();
//        final int count = judgement.correctCount(Arrays.asList(7, 8, 9), Arrays.asList(1, 2, 3));
//        System.out.println(count);

        final boolean place = judgement.hasPlace(Arrays.asList(7, 8, 9), 0, 7); // 첫 번째(0)가 7이냐?
        System.out.println(place); // true
    }
}
