package baseball;

import java.util.Scanner;
import utils.RandomUtils;
import java.util.HashSet;
import java.util.Set;

final class StrikeAndBall {
    int strike;
    int ball;

    public StrikeAndBall(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}

public class Application {

    public static int guessNum(Scanner scanner) {
        System.out.print("숫자를 입력해 주세요 : ");
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException("정수가 아닙니다");
        }

        int input = scanner.nextInt();

        if (100 <= input && input < 1000) {
            return input;
        } else {
            throw new IllegalArgumentException("3자리 정수만 입력 가능합니다");
        }
    }
    public static int[] intToArray(int num) {
        int[] this_array = new int[3];
        for (int i = 2; i > -1; i--) {
            this_array[i] = num % 10;
            num /= 10;
        }
        return this_array;
    }

    public static boolean isValidateRandomNum(int candidate) {
        Set<Integer> store = new HashSet<>();

        int[] candidate_array = intToArray(candidate);
        for (int i : candidate_array) {
            System.out.println(i);
            if (store.contains(i) || i == 0) {
                return false;
            }
            store.add(i);
        }
        return true;
    }

    public static StrikeAndBall countStrikeAndBall(int guessNum, int answer) {
        int[] guessArray = intToArray(guessNum);
        int[] answerArray = intToArray(answer);
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                strike += countStrike(guessArray[i], i, answerArray[j], j);
                ball += countBall(guessArray[i], i, answerArray[j], j);
            }
        }
        return new StrikeAndBall(strike, ball);
    }

    public static int countStrike(int num1, int index1, int num2, int index2) {
        if (index1 == index2 && num1 == num2) {
            return 1;
        }
        return 0;
    }

    public static int countBall(int num1, int index1, int num2, int index2) {
        if (index1 != index2 && num1 == num2) {
            return 1;
        }
        return 0;
    }

    public static void resultOfGuess(int strikeCount, int ballCount) {
        if (0 < strikeCount && 0 < ballCount) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        else if (0 < strikeCount && 0 == ballCount) {
            System.out.println(strikeCount + "스트라이크");
        }
        else if (0 == strikeCount && 0 < ballCount) {
            System.out.println(ballCount + "볼");
        }
        else if (0 == strikeCount && 0 == ballCount) {
            System.out.println("낫싱");
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        // 3자리 숫자 생성
        int answer;
        do {
            answer = RandomUtils.nextInt(100, 999);
        } while (!isValidateRandomNum(answer));
        System.out.println(answer);

        int number;
        do {
            number = guessNum(scanner);
            StrikeAndBall thisTurnResult = countStrikeAndBall(number, answer);
            int strikeCount = thisTurnResult.getStrike();
            int ballCount = thisTurnResult.getBall();
            resultOfGuess(strikeCount, ballCount);
        } while (number != answer);
        System.out.println("숫자를 맞히셨습니다! 게임 종료");
    }
}
