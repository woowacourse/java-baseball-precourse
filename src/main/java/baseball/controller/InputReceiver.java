package baseball.controller;

import baseball.viewer.InputViewer;

import java.util.Scanner;

public class InputReceiver {
    private static final int NUMBER_OF_BALL = 3;
    private static final int ONE_DIGIT = 10;
    private static final String RESTART = "1";
    private static final String END = "2";
    private static final Scanner receiver = new Scanner(System.in);

    /**
     * 사용자에게서 받는 숫자들을 정수형으로 변경한 후 각자리 숫자를 배열로 전환하는 메서드
     *
     * @return 전환된 정수들의 배열
     */
    public static int[] userAnswer() {
        InputViewer.receiveNumber();
        String userInitialAnswer = receiver.nextLine();
        lengthChecker(userInitialAnswer);
        int userIntegerAnswer = integerTranslator(userInitialAnswer);
        int[] userAnswer = intergerArrayTranslator(userIntegerAnswer);
        overlappedChecker(userAnswer);
        return userAnswer;
    }

    private static void lengthChecker(String userInitialAnswer) {
        if (userInitialAnswer.length() > 3) {
            InputViewer.excessDigits();
        }
        if (userInitialAnswer.length() < 3) {
            InputViewer.lackDigits();
        }
    }

    private static int[] intergerArrayTranslator(int userIntegerAnswer) {
        int[] integerArray = new int[NUMBER_OF_BALL];
        for (int position = 0; position < NUMBER_OF_BALL; position++) {
            int singleNumber = userIntegerAnswer % ONE_DIGIT;
            zeroChecker(singleNumber);
            integerArray[NUMBER_OF_BALL - position - 1] = singleNumber;
            userIntegerAnswer /= ONE_DIGIT;
        }
        return integerArray;
    }

    private static int integerTranslator(String userInitialAnswer) {
        int integerAnswer = 0;
        try {
            integerAnswer = Integer.parseInt(userInitialAnswer);
        } catch (Exception notIntegerType) {
            InputViewer.violentIntegerRule();
        }
        return integerAnswer;
    }

    private static void zeroChecker(int singleNumber) {
        if (singleNumber == 0) {
            InputViewer.zeroCheck();
        }
    }

    private static void overlappedChecker(int[] integerArray) {
        for (int turn = 0; turn < NUMBER_OF_BALL; turn++) {
            comparedOne(integerArray, turn);
        }
    }

    private static void comparedOne(int[] integerArray, int turn) {
        for (int j = turn + 1; j < NUMBER_OF_BALL; j++) {
            if (integerArray[turn] == integerArray[j]) {
                InputViewer.overlappedReceive();
            }
        }
    }

    /**
     * 게임을 계속 종료할 것인지를 묻는 메서드
     *
     * @return false : 게임 새로 시작, true : 전체 게임 종료
     */
    public static boolean askEndGames() {
        String criteria = receiver.nextLine();
        if (criteria.equals(RESTART)) {
            return false;
        }
        if (criteria.equals(END)) {
            return true;
        }
        InputViewer.noValidRestart();
        return false;
    }
}
