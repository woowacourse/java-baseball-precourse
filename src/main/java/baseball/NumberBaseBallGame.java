package baseball;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import utils.RandomUtils;

public class NumberBaseBallGame {

    private static List<Integer> answerNumber = new LinkedList<>();
    private static List<Integer> questionNumber = new LinkedList<>();
    private static int strike, ball;
    private static Scanner scanner;

    public NumberBaseBallGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void initGameData() {
        answerNumber.clear();
        questionNumber.clear();
        strike = 0;
        ball = 0;
    }

    public static void setAnswerNumber() {
        Set<Integer> set = new HashSet<>();

        answerNumber.clear();
        while (answerNumber.size() < 3) {
            int num = RandomUtils.nextInt(1, 9);
            if (!set.contains(num)) {
                set.add(num);
                answerNumber.add(num);
            }
        }
    }

    public static void setQuestionNumber() {
        int num = getQuestionNumber();

        while (num > 0) {
            questionNumber.add(num % 10);
            num /= 10;
        }
        Collections.reverse(questionNumber);
    }

    public static int getQuestionNumber() {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            int input = scanner.nextInt();
            checkIsLessZero(input);
            checkDigitLength(input);
            checkRangeEachOfDigit(input, 1, 9);
            checkIsDuplicateDigit(input);
            return input;
        } catch (Exception e) {
            return getQuestionNumber();
        }
    }

    private static void checkIsLessZero(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDigitLength(int num) {
        if ((int) (Math.log10(num) + 1) != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkRangeEachOfDigit(int num, int min, int max) {
        while (num > 0) {
            int digit = num % 10;
            if (!(digit >= min && digit <= max)) {
                throw new IllegalArgumentException();
            }
            num /= 10;
        }
    }

    private static void checkIsDuplicateDigit(int num) {
        Set<Integer> set = new HashSet<>();

        while (num > 0) {
            if (set.contains(num % 10)) {
                throw new IllegalArgumentException();
            }
            set.add(num % 10);
            num /= 10;
        }
    }

    private static void validateQuestionNumber() {
        for (int i = 0; i < 3; i++) {
            if (answerNumber.get(i) == questionNumber.get(i)) {
                strike++;
            } else if (answerNumber.contains(questionNumber.get(i))) {
                ball++;
            }
        }
    }

    private static boolean isThreeStrike() {
        if (strike == 3) {
            return true;
        }
        return false;
    }

    private static void printBallAndStrike() {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }

        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }

        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

}
