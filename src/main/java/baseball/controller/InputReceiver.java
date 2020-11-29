package baseball.controller;

import java.util.Scanner;
import baseball.viewer.InputViewer;

public class InputReceiver {
    static final int NUMBEROFBALL = 3;
    static final Scanner receiver = new Scanner(System.in);

    public static int[] userAnswer() {
        int[] userAnswer;
        InputViewer.receiveNumber();
        String userInitialAnswer = receiver.nextLine();
        lengthChecker(userInitialAnswer);
        userAnswer = intergerArrayTranslator(userInitialAnswer);
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

    private static int[] intergerArrayTranslator(String userIntialAnswer) {
        int userIntegerAnswer = integerTranslator(userIntialAnswer);
        int[] integerArray = new int[NUMBEROFBALL];

        for (int position = 0; position < NUMBEROFBALL; position++) {
            int singleNumber = userIntegerAnswer % 10;
            zeroChecker(singleNumber);
            integerArray[NUMBEROFBALL - position - 1] = singleNumber;
            userIntegerAnswer /= 10;
        }

        overlappedChecker(integerArray);
        return integerArray;
    }

    private static int integerTranslator(String userInitialAnswer) {
        int integerAnswer =0;

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
        for (int turn = 0; turn < NUMBEROFBALL; turn++) {
            comparedOne(integerArray, turn);
        }
    }

    private static void comparedOne(int[] integerArray, int turn) {
        for (int j = turn + 1; j < NUMBEROFBALL; j++) {
            if (integerArray[turn] == integerArray[j]) {
                InputViewer.overlappedReceive();
            }
        }
    }

    public static boolean askEndGames() {
        String criteria = receiver.nextLine();
        if (criteria.equals("1")) {
            return false;
        }

        if (criteria.equals("2")) {
            return true;
        }

        InputViewer.noValidRestart();
        return false;
    }
}
