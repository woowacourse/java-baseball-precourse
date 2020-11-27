package baseball;

import utils.RandomUtils;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int[] answer = generateAnswer();
        int[] inputNumber;
        int input;

        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            input = scanner.nextInt();
            inputNumber = Stream.of(String.valueOf(input).split(""))
                    .mapToInt(Integer::parseInt).toArray();
            throwErrorIfWrongInput(input, inputNumber);
        }
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

    public static void throwErrorIfWrongInput(int input, int[] inputNumber) {
        if(input < 100 || input > 999 || inputNumber[0] == inputNumber[1] ||
                inputNumber[0] == inputNumber[2] || inputNumber[1] == inputNumber[2]) {
            throw new IllegalArgumentException();
        }
    }
}