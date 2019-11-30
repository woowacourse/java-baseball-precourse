package baseballgame;

import java.util.Random;

public class BaseballGame {
    private static final int MAX_NUM = 900;
    private static final int ZERO = 0;
    private static final int INPUT_LENGTH = 3;

    String getRandomNumber() {
        String randomNumber;

        do {
            randomNumber = Integer.toString(generateRandomNumber());

        } while (hasZero(randomNumber) || hasDuplicatedNumber(randomNumber));

        return randomNumber;

    }

    private int generateRandomNumber() {
        int randomNum;
        Random random = new Random();
        randomNum = random.nextInt(MAX_NUM) + 100;
        return randomNum;
    }

    void getScore(String targetNumber, String inputNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (checkStrike(targetNumber, inputNumber, i)) {
                strike++;
            } else if (checkBall(targetNumber, inputNumber, i)) {
                ball++;
            }
        }
        printResult(strike, ball);
    }

    private boolean checkStrike(String targetNumber, String inputNumber, int i) {
        return targetNumber.charAt(i) == inputNumber.charAt(i);
    }

    private boolean checkBall(String targetNumber, String inputNumber, int i) {
        return targetNumber.contains(String.valueOf(inputNumber.charAt(i)));
    }

    private void printResult(int strike, int ball) {
        StringBuilder sb = new StringBuilder();

        if (strike != ZERO) {
            sb.append(strike + " 스트라이크 ");
        }

        if (ball != ZERO) {
            sb.append(ball + " 볼");
        }

        if (strike == ZERO && ball == ZERO) {
            sb.append("낫싱");
        }

        System.out.println(sb.toString());
    }

    boolean isValidNumber(String number) {
        // 순서 중요! 숫자인지 먼저 확인해야한다.
        if (!isNumeric(number) || !isValidLengthOfInputNumber(number) || hasZero(number) || hasDuplicatedNumber(number)) {
            return false;
        }
        return true;
    }

    private boolean hasZero(String number) {
        return number.contains("0");
    }

    private boolean hasDuplicatedNumber(String number) {
        String temp;

        for (int i = 0; i < 2; i++) {
            temp = number.replaceFirst(String.valueOf(number.charAt(i)), "");
            if (temp.contains(String.valueOf(number.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidLengthOfInputNumber(String inputNumber) {
        if (inputNumber.length() == INPUT_LENGTH) {
            return true;
        }
        return false;
    }

    private boolean isNumeric(String inputNumber) {
        if (inputNumber == null || inputNumber.length() == ZERO) {
            return false;
        }
        return inputNumber.chars().allMatch(Character::isDigit);
    }

}