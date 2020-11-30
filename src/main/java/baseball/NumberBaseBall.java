package baseball;

import utils.RandomUtils;

public class NumberBaseBall {
    private static final int INITIAL_VALUE = 0;
    private static final int NUMBER_SIZE = 3;
    private static final int GAME_OVER = 3;

    private String randomNumber;

    protected String makeHint(String playerNums, String randomNums) {
        char[] player = playerNums.toCharArray();
        char[] random = randomNums.toCharArray();
        int ball = INITIAL_VALUE;
        int strike = INITIAL_VALUE;

        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (player[i] == random[i]) {
                strike++;
            }
        }

        for (int i = 0; i < NUMBER_SIZE; i++) {
            String compareValue = String.valueOf(player[i]);
            if (randomNums.contains(compareValue)) {
                ball++;
            }
        }
        if (ball > 0) {
            ball = ball - strike;
        }
        return makeResult(ball, strike);
    }

    private String makeResult(int ball, int strike) {
        StringBuilder result = new StringBuilder();

        if (strike == GAME_OVER) {
            result.append(strike + "스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (ball > 0 && strike > 0) {
            result.append(ball + "볼 " + strike + "스트라이크");
        } else if (strike > 0) {
            result.append(strike + "스트라이크");
        } else if (ball > 0) {
            result.append(ball + "볼");
        } else {
            result.append("낫싱");
        }
        return result.toString();
    }

    protected void createRandomNumber(int minNumber, int maxNumber) {
        StringBuilder makeRandomNum = new StringBuilder();

        while (makeRandomNum.length() != NUMBER_SIZE) {
            String creatNum = String.valueOf(RandomUtils.nextInt(minNumber, maxNumber));
            if (makeRandomNum.indexOf(creatNum) < 0) {
                makeRandomNum.append(creatNum);
            }
        }
        this.randomNumber = makeRandomNum.toString();
    }

    public String getRandomNumbers() {
        return randomNumber;
    }
}
