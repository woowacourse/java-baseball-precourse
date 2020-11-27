package baseball;

import utils.RandomUtils;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int[] answer = generateAnswer();
    }

    public static int[] generateAnswer() {
        int[] answer = new int[3];

        for (int i = 0; i < answer.length; i++) {
            int tmpAnswer = RandomUtils.nextInt(1, 9);

            if (IntStream.of(answer).anyMatch(x -> x == tmpAnswer)) {
                i--;
                continue;
            }

            answer[i] = tmpAnswer;
        }
        return answer;
    }
}