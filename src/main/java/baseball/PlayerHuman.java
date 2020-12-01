package baseball;

import java.util.Scanner;

public class PlayerHuman {
    private static final String MESSAGE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String MESSAGE_ASK_GAME_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String MESSAGE_INPUT_ERROR_RESTART = "1과 2 중에 하나를 입력해주세요!";
    private static final String MESSAGE_INPUT_ERROR_DUPLICATION = "중복된 숫자가 입력되었습니다!";
    private static final String MESSAGE_INPUT_ERROR_NUMBER = "1에서 9까지 숫자를 입력해주세요!";
    private static final String MESSAGE_INPUT_ERROR_NUMBER_LENGTH = "알맞은 길이의 숫자를 입력해주세요!";
    private static final int INITIALIZER = -1;
    private static final int GAME_RESTART = 1;
    private static final int GAME_END = 2;
    private static final String DELIMITER = "";
    private static int[] records = new int[Judge.RECORD_LENGTH];


    public int[] getRecords(Scanner scanner) {
        initializeRecords();
        System.out.printf(MESSAGE_INPUT_NUMBER);
        String[] stringArrayRecords = scanner.next().split(DELIMITER);
        return convertStringToInteger(stringArrayRecords);
    }


    private void initializeRecords() {
        for(int i = 0; i < records.length; i++) {
            records[i] = INITIALIZER;
        }
    }

    private int[] convertStringToInteger(String[] stringArrayRecords) {
        isValidInput(stringArrayRecords);
        for(int i = 0; i < Judge.RECORD_LENGTH; i++) {
            int numberPlayerInput = Integer.parseInt(stringArrayRecords[i]);
            if (isSameDigitInRecords(records, numberPlayerInput)) {
                throw new IllegalArgumentException(MESSAGE_INPUT_ERROR_DUPLICATION);
            }
            records[i] = numberPlayerInput;
        }
        return records;
    }

    private void isValidInput(String[] stringArrayRecords) {
        AreNumbers(stringArrayRecords);
        isRightLength(stringArrayRecords, Judge.RECORD_LENGTH);
    }

    private void AreNumbers(String[] stringArrayRecords) {
        for(int i = 0; i<stringArrayRecords.length; i++) {
            try {
                Integer.parseInt(stringArrayRecords[i]);
            } catch (Exception e) {
                throw new IllegalArgumentException(MESSAGE_INPUT_ERROR_NUMBER);
            }
        }
    }

    private void isRightLength(String[] stringArrayRecords, int recordLength) {
        if(stringArrayRecords.length != recordLength) {
            throw new IllegalArgumentException(MESSAGE_INPUT_ERROR_NUMBER_LENGTH);
        }
    }

    private boolean isSameDigitInRecords(int[] records, int newDigit) {
        for(int i = 0; i < records.length; i++) {
            if(newDigit == records[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean wantToRestart(Scanner scanner) {
        System.out.println(MESSAGE_ASK_GAME_RESTART);
        int answerPlayerInput;
        try {
            answerPlayerInput = scanner.nextInt();
        } catch(Exception e) {
            throw new IllegalArgumentException(MESSAGE_INPUT_ERROR_RESTART);
        }
        if(answerPlayerInput != GAME_RESTART && answerPlayerInput != GAME_END) {
            throw new IllegalArgumentException(MESSAGE_INPUT_ERROR_RESTART);
        }
        return answerPlayerInput == GAME_RESTART;
    }
}
