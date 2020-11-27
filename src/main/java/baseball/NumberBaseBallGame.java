package baseball;

import utils.RandomUtils;

public class NumberBaseBallGame {

    protected String makeHint(String playerNums, String randomNums) {
        StringBuilder result = new StringBuilder();
        char[] player = playerNums.toCharArray();
        char[] random = randomNums.toCharArray();
        int ball = 0;
        int strike = 0;
        //스트라이크 찾기
        for (int i = 0; i < player.length; i++) {
            if (player[i] == random[i])
                strike++;
        }
        //볼 찾기
        for (int i = 0; i < player.length; i++) {
            if (randomNums.contains("" + player[i]))
                ball++;
        }
        if (ball > 0)
            ball = ball - strike;
        //낫싱
        if (ball > 0 && strike > 0) {
            result.append(ball + "볼 " + strike + "스트라이크");
        } else if (ball > 0) {
            result.append(ball + "볼");
        } else if (strike > 0) {
            result.append(strike + "스트라이크");
        } else
            result.append("낫싱");
        return result.toString();
    }

    protected String makeRandomNumber(int minNumber, int maxNumber) {
        String randomNumbers = "";
        for (int randomIndex = 0; randomIndex < 3; randomIndex++) {
            randomNumbers += RandomUtils.nextInt(minNumber, maxNumber);
        }
        return randomNumbers;
    }
}
