package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final int START_BOUND = 1;
    private static final int END_BOUND = 9;

    private static final int REPEAT_GAME = 1;
    private static final int END_GAME = 2;

    private static Scanner globalScanner;

    private static boolean isRepeat = true;
    private static String inputStr;
    private static List<Integer> answers = new ArrayList<>();
    private static List<Integer> inputs = new ArrayList<>();

    private static int ball;
    private static int strike;

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        globalScanner = scanner;

        while (isRepeat) {
            startGame();
            getIsRepeat();
        }
    }

    private static void startGame() {
        generateNewAnswers();
        playGame();
    }


    private static void generateNewAnswers() {
        initAnswers();
        while (answers.size() < 3)
            generateOneAnswer();
    }

    private static void initAnswers() {
        answers.clear();
    }

    private static void generateOneAnswer() {
        int newAnswer = RandomUtils.nextInt(START_BOUND, END_BOUND);
        if (isUniqueAnswer(newAnswer))
            answers.add(newAnswer);
    }

    private static boolean isUniqueAnswer(int given) {
        return !answers.contains(given);
    }


    private static void playGame() {
        do {
            initParams();
            getNumsInput();
            checkInputs();
            printHint();
        } while (strike < 3);
        printGameFinished();
    }


    private static void initParams() {
        initHintCounts();
        initInputs();
    }

    private static void initHintCounts() {
        ball = 0;
        strike = 0;
    }

    private static void initInputs() {
        inputs.clear();
    }


    private static void getNumsInput() {
        getInputStr();
        try {
            parseInputStrToNums();
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void getInputStr() {
        System.out.print("숫자를 입력해주세요 : ");
        inputStr = globalScanner.nextLine();
    }

    private static void parseInputStrToNums() {
        for (int i = 0; i < 3; i++) {
            inputs.add(Integer.parseInt(inputStr.substring(i, i + 1)));
        }
    }


    private static void checkInputs() {
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


    private static void getIsRepeat() {
        try {
            int repeatInput = getRepeatInput();
            parseIsRepeat(repeatInput);
        } catch (InputMismatchException | NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static int getRepeatInput() {
        int repeatInput = globalScanner.nextInt();
        globalScanner.nextLine();
        return repeatInput;
    }

    private static void parseIsRepeat(int repeatInput) {
        if (repeatInput == REPEAT_GAME)
            isRepeat = true;
        else if (repeatInput == END_GAME)
            isRepeat = false;
        else
            throw new IllegalArgumentException();
    }
}