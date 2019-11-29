package baseballgame;

import java.util.Random;

public class BaseballGame {
    private final int MAX_NUM = 900;

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

        if (strike != 0) {
            sb.append(strike + " 스트라이크 ");
        }

        if (ball != 0) {
            sb.append(ball + " 볼");
        }

        if (strike == 0 && ball == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb.toString());
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

}