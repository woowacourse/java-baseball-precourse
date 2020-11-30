package baseball;

import java.util.Scanner;

public class PlayerHuman {
    private static final String MESSAGE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String MESSAGE_ASK_GAME_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String MESSAGE_INPUT_ERROR = "1과 2 중에 하나를 입력해주세요!";
    private static final int GAME_RESTART = 1;
    private static int[] records = new int[Judge.RECORD_LENGTH];

    static {
        for(int i = 0; i < records.length; i++)
            records[i] = -1;
    }

    public int[] getRecords(Scanner scanner) {
        int[] records = new int[Judge.RECORD_LENGTH];
        return records;
    }

    public boolean wantToRestart(Scanner scanner) {
        System.out.println(MESSAGE_ASK_GAME_RESTART);
        int answerPlayerInput;
        try {
            answerPlayerInput = scanner.nextInt();
        } catch(Exception e) {
            throw new IllegalArgumentException(MESSAGE_INPUT_ERROR);
        }
        if(answerPlayerInput != 1 && answerPlayerInput != 2)
            throw new IllegalArgumentException(MESSAGE_INPUT_ERROR);
        if(answerPlayerInput == GAME_RESTART)
            return true;
        return false;
    }
}
