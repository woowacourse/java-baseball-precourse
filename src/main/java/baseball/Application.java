package baseball;

import utils.RandomUtils;

import java.util.ArrayList;
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
            initGame();
            getIsRepeat();
        }
    }

    private static void initGame() {
        generateNewAnswers();
        System.out.println(answers);
        playGame();
    }

    private static void playGame() {
        do {
            initParams();
            getNumsInput();
            checkInputNums();
            printHint();
        } while (strike < 3);
        printGameFinished();
    }


    private static void generateNewAnswers() {
        answers.clear();
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


    private static void getNumsInput() {
        getInputStr();
        parseInputStrToNums();
    }

    private static void getInputStr() {
        System.out.print("숫자를 입력해주세요 : ");
        inputStr = globalScanner.nextLine();
    }

    private static void parseInputStrToNums() {
        for (int i = 0; i < 3; i++) {
            inputs.add(Integer.parseInt(inputStr.substring(i, i + 1))); // TODO 비정상적 입력 처리 (파싱 오류)
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


    private static void getIsRepeat() {
        int repeatInput = getRepeatInput();
        parseIsRepeat(repeatInput);
    }

    private static int getRepeatInput() {
        int repeatInput = globalScanner.nextInt(); // TODO 비정상적 입력 처리 (숫자가 아닌 input)
        globalScanner.nextLine();
        return repeatInput;
    }

    private static void parseIsRepeat(int repeatInput) {
        if (repeatInput == REPEAT_GAME)
            isRepeat = true;
        else if (repeatInput == END_GAME)
            isRepeat = false;
        // TODO 비정상적 입력 처리 (1,2 이외 숫자)
    }
}