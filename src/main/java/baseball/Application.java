package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final int START_BOUND = 1;
    private static final int END_BOUND = 9;

    private static Scanner globalScanner;

    private static String inputStr;
    private static List<Integer> answers = new ArrayList<>();
    private static List<Integer> inputs = new ArrayList<>();

    private static int ball;
    private static int strike;

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        globalScanner = scanner;
        playGame();
    }

    private static void playGame() {
        generateAnswers();
        while (strike < 3) {
            initParams();
            getInputNums();
            checkInputNums();
            printHint();
        }
        printGameFinished();
        System.out.println(answers);
    }

    private static void generateAnswers() {
        while (answers.size() < 3)
            generateOneAnswer();
    }

    private static void generateOneAnswer() {
        int newAnswer = RandomUtils.nextInt(START_BOUND, END_BOUND);
        if (isUniqueAnswer(newAnswer))
            answers.add(newAnswer);
    }

    private static boolean isUniqueAnswer(int given) {
        return !answers.contains(given);
    }


    private static void initParams() {
        initHintCount();
        initInputs();
    }

    private static void initHintCount() {
        ball = 0;
        strike = 0;
    }

    private static void initInputs() {
        inputs.clear();
    }


    private static void getInputNums() {
        getInputStr();
        parseInputStr();
    }

    private static void getInputStr() {
        System.out.print("숫자를 입력해주세요 : ");
        inputStr = globalScanner.nextLine();
    }

    private static void parseInputStr() {
        for (int i = 0; i < 3; i++) {
            inputs.add(Integer.parseInt(inputStr.substring(i, i + 1)));
        }

    }


    private static void checkInputNums() {
        for (int input : inputs)
            checkOneInput(input);
    }

    private static void checkOneInput(int input) {
        if (answers.contains(input) && answers.indexOf(input) == inputs.indexOf(input))
            strike++;
        else if (answers.contains(input))
            ball++;
    }


    private static void printHint() {
        printNothing();
        printBall();
        printStrike();
        System.out.println();
    }

    private static void printNothing() {
        if (strike == 0 && ball == 0)
            System.out.print("낫싱");
    }

    private static void printBall() {
        if (ball != 0)
            System.out.print(ball + "볼 ");
    }

    private static void printStrike() {
        if (strike != 0)
            System.out.print(strike + "스트라이크");
    }


    private static void printGameFinished() {
        System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
