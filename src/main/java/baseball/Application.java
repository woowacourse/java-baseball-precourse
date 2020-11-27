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
            System.out.print("숫자를 입력해주세요 : ");
            input = scanner.nextInt();
            inputNumber = Stream.of(String.valueOf(input).split(""))
                    .mapToInt(Integer::parseInt).toArray();
            throwErrorIfWrongInput(input, inputNumber);

            if (!isAllStrike(answer, inputNumber)) {
                continue;
            }else if (stopGame(scanner.nextInt())) {
                break;
            } else {
                answer = generateAnswer();
            }
        }
        scanner.close();
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
        if (input < 100 || input > 999 || inputNumber[0] == inputNumber[1] ||
                inputNumber[0] == inputNumber[2] || inputNumber[1] == inputNumber[2]
                || IntStream.of(inputNumber).anyMatch(x -> x == 0)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isAllStrike(int[] answer, int[] inputNumber) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < inputNumber.length; i++) {
            int j = i;
            if (inputNumber[i] == answer[i]) {
                strikeCount++;
            } else if (IntStream.of(answer).anyMatch(x -> x == inputNumber[j])) {
                ballCount++;
            }
        }
        printHint(ballCount, strikeCount);

        return strikeCount == 3;
    }

    public static void printHint(int ballCount, int strikeCount) {
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } else if (strikeCount + ballCount == 0) {
            System.out.println("낫싱");
        } else {
            if (ballCount != 0) {
                System.out.print(ballCount + "볼 ");
            }
            if (strikeCount != 0) {
                System.out.print(strikeCount + "스트라이크");
            }
            System.out.println();
        }
    }

    private static boolean stopGame(int input) {
        if (input == 2) {
            return true;
        } else if (input != 1) {
            throw new IllegalArgumentException();
        }
        return false;
    }
}