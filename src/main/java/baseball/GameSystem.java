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
        while (true) {
            setUserNumbers(sc);
            calcScore();
            user.printInfoForTest();
            if (user.getStrike() == 3) {
                break;
            }
        }
    }

    private void setAnswer() {
        boolean[] numCheck = new boolean[10];
        int digit = 0;
        int tmpNum;

        while (digit < MAX_DIGIT) {
            tmpNum = RandomUtils.nextInt(1, 9);
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

    private void calcScore() {
        int ball = 0;
        int strike = 0;
        int[] userNumbers = user.getNumbers();

        for (int i = 0; i < MAX_DIGIT; i++) {
            ball += checkOneBall(i, userNumbers[i]);
            strike += checkOneStrike(i, userNumbers[i]);
        }
        user.setBall(ball);
        user.setStrike(strike);
    }

    private int stringToValidNum(String string) throws IllegalArgumentException {
        if (!isStringLengthValid(string)) {
            throw new IllegalArgumentException("입력이 3자리가 아닙니다. 숫자 재입력이 필요합니다.");
        }
        if (!isStringDigitValid(string)) {
            throw new IllegalArgumentException("입력이 숫자로 이루어져 있지 않습니다. 숫자 재입력이 필요합니다.");
        }
        if (!isStringNoZero(string)) {
            throw new IllegalArgumentException("입력이 0을 포함합니다. 숫자 재입력이 필요합니다.");
        }
        return Integer.parseInt(string);
    }

    private boolean isStringLengthValid(String string) {
        if (string.length() != MAX_DIGIT) {
            return false;
        }
        return true;
    }

    private boolean isStringDigitValid(String string) {
        int length = string.length();

        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
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

    private int checkOneBall(int position, int userNum) {
        int ball = 0;

        for (int i = 0; i < MAX_DIGIT; i++) {
            if ((i != position) && (answer[i] == userNum)) {
                ball++;
            }
        }
        return ball;
    }

    private int checkOneStrike(int position, int userNum) {
        int strike = 0;

        if (answer[position] == userNum) {
            strike++;
        }
        return strike;
    }

    public void printAnswerForTest() {
        for (int i = 0; i < MAX_DIGIT; i++) {
            System.out.println(answer[i]);
        }
    }
}
