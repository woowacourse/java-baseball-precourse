package baseball;

import utils.RandomUtils;

public class NumberBaseBall {
    public String randomNumber;
    private static int INITIAL_VALUE = 0;
    private static int NUMBER = 3;

    protected String makeHint(String playerNums, String randomNums) {
        char[] player = playerNums.toCharArray();
        char[] random = randomNums.toCharArray();
        int ball = INITIAL_VALUE;
        int strike = INITIAL_VALUE;
        //스트라이크 찾기
        for (int i = 0; i < NUMBER; i++) {
            if (player[i] == random[i])
                strike++;
        }
        //볼 찾기
        for (int i = 0; i < NUMBER; i++) {
            if (randomNums.contains("" + player[i]))
                ball++;
        }
        if (ball > INITIAL_VALUE)
            ball = ball - strike;
        return makeResult(ball, strike);//결과 만들기
    }

    private String makeResult(int ball, int strike)
    {
        StringBuilder result = new StringBuilder();

        if (ball > INITIAL_VALUE && strike > INITIAL_VALUE) {
            result.append(ball + "볼 " + strike + "스트라이크");
        } else if (ball > INITIAL_VALUE) {
            result.append(ball + "볼");
        } else if (strike > INITIAL_VALUE) {
            result.append(strike + "스트라이크");
            if (strike == 3) {
                result.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }else
            result.append("낫싱");
        return result.toString();
    }

    protected String makeRandomNumber(int minNumber, int maxNumber) {
        String randomNumbers = "";
        for (int randomIndex = 0; randomIndex < NUMBER; randomIndex++) {
            randomNumbers += RandomUtils.nextInt(minNumber, maxNumber);
        }
        return randomNumbers;
    }

    public void setRandomNumber(String randomNumber) {
        this.randomNumber = randomNumber;
    }
}
