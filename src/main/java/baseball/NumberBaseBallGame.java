package baseball;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import utils.RandomUtils;

public class NumberBaseBallGame {

    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final int NUMBER_LEN = 3;
    private static final int CONTINUE = 1;
    private static final int END = 2;
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
        initStrikeAndBall();
    }

    private static void initStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    public static void setAnswerNumber() {
        Set<Integer> set = new HashSet<>();

        answerNumber.clear();
        while (answerNumber.size() < NUMBER_LEN) {
            int num = RandomUtils.nextInt(MIN, MAX);
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
            checkRangeEachOfDigit(input, MIN, MAX);
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
        if ((int) (Math.log10(num) + 1) != NUMBER_LEN) {
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
        for (int i = 0; i < NUMBER_LEN; i++) {
            if (answerNumber.get(i) == questionNumber.get(i)) {
                strike++;
            } else if (answerNumber.contains(questionNumber.get(i))) {
                ball++;
            }
        }
    }

    private static boolean isThreeStrike() {
        if (strike == NUMBER_LEN) {
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

    private static void printCorrectAnswerMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static void printContinueGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static int getGameContinueFlag() {
        try {
            printContinueGameMessage();
            int input = scanner.nextInt();
            checkIsContinueFlag(input);
            return input;
        } catch (Exception e) {
            return getGameContinueFlag();
        }
    }

    private static void checkIsContinueFlag(int num) {
        if (num != CONTINUE && num != END) {
            throw new IllegalArgumentException();
        }
    }

    public static void run() {
        int flag = CONTINUE;
        initGameData();
        setAnswerNumber();

        while (flag == CONTINUE) {
            setQuestionNumber();
            initStrikeAndBall();
            validateQuestionNumber();
            printBallAndStrike();
            if (isThreeStrike()) {
                printCorrectAnswerMessage();
                flag = getGameContinueFlag();
            }
            if (isThreeStrike() && flag == CONTINUE) {
                initGameData();
                setAnswerNumber();
            }
        }
    }

}
