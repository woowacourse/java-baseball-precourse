package baseball;

import utils.RandomUtils;

import java.util.Arrays;

public class NumberBaseBall {
    private String randomNumber;
    private static int INITIAL_VALUE = 0;
    private static int NUMBER_SIZE = 3;

    protected String makeHint(String playerNums, String randomNums) {
        char[] player = playerNums.toCharArray();
        char[] random = randomNums.toCharArray();
        int ball = INITIAL_VALUE;
        int strike = INITIAL_VALUE;

        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (player[i] == random[i])
                strike++;
        }
        Arrays.sort(random);
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (Arrays.binarySearch(random, player[i]) >= 0)
                ball++;
        }
        if (ball > INITIAL_VALUE)
            ball = ball - strike;
        return makeResult(ball, strike);
    }

    private String makeResult(int ball, int strike)
    {
        StringBuilder result = new StringBuilder();
        if (strike == 3) {
            result.append(strike + "스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        else if (ball > INITIAL_VALUE && strike > INITIAL_VALUE) {
            result.append(ball + "볼 " + strike + "스트라이크");
        }
        else if (strike > INITIAL_VALUE) {
            result.append(strike + "스트라이크");
        }
        else if (ball > INITIAL_VALUE) {
            result.append(ball + "볼");
        }
        else
            result.append("낫싱");
        return result.toString();
    }

    protected String makeRandomNumber(int minNumber, int maxNumber) {
        StringBuilder randomNumber = new StringBuilder();
        while (randomNumber.length() != NUMBER_SIZE)
        {
            String creatNum = String.valueOf(RandomUtils.nextInt(minNumber, maxNumber));
            if (randomNumber.indexOf(creatNum) < 0)
                randomNumber.append(creatNum);
        }
        return randomNumber.toString();
    }

    public void setRandomNumber(String randomNumber) {
        this.randomNumber = randomNumber;
    }

    public String getRandomNumbers() {
        return randomNumber;
    }
}
