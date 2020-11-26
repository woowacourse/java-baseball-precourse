package baseball;

import java.util.Scanner;

import utils.RandomUtils;

public class GameSystem {
    private static final int MAX_DIGIT = 3;

    // 정답이 될 컴퓨터의 3자리 수
    private int[] answer;
    private User user;

    public GameSystem() {
        answer = new int[MAX_DIGIT];
        user = new User();
    }

    public void playGame(Scanner sc) {
        setAnswer();
        setUserNumbers(sc);
    }

    private void setAnswer() {
        boolean[] numCheck = new boolean[10];
        int digit = 0;
        int tmpNum;

        while (digit < MAX_DIGIT) {
            tmpNum = RandomUtils.nextInt(1, 10);
            if (!numCheck[tmpNum]) {
                answer[digit] = tmpNum;
                numCheck[tmpNum] = true;
                digit++;
            }
        }
    }

    private void setUserNumbers(Scanner sc) {
        int num = 0;
        boolean checkNumValid = false;

        while (!checkNumValid) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = sc.nextLine();

            try {
                num = stringToValidNum(input);
                checkNumValid = true;
            } catch (IllegalArgumentException e) {
                String exceptionMessage = e.getMessage();
                System.out.println(exceptionMessage);
            }
        }
        user.setNumbers(num);
    }

    private int stringToValidNum(String string) throws IllegalArgumentException {
        if (!isStringNumber(string)) {
            throw new IllegalArgumentException("입력이 숫자가 아닙니다. 숫자 재입력이 필요합니다.");
        }
        if (!isStringLengthValid(string)) {
            throw new IllegalArgumentException("입력이 3자리가 아닙니다. 숫자 재입력이 필요합니다.");
        }
        if (!isStringNoZero(string)) {
            throw new IllegalArgumentException("입력이 0을 포함합니다. 숫자 재입력이 필요합니다.");
        }
        return Integer.parseInt(string);
    }

    private boolean isStringNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isStringLengthValid(String string) {
        if (string.length() != MAX_DIGIT) {
            return false;
        }
        return true;
    }

    private boolean isStringNoZero(String string) {
        int length = string.length();

        for (int i = 0; i < length; i++) {
            if (string.charAt(i) == '0') {
                return false;
            }
        }
        return true;
    }

    public void printAnswerForTest() {
        for (int i = 0; i < MAX_DIGIT; i++) {
            System.out.println(answer[i]);
        }
    }
}
