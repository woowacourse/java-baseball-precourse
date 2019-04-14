package com.teco;

import java.util.Map;

/**
 * 컴퓨터와 사용자 입력 숫자를 비교
 *
 * @author 김성훈
 * @version 1.0
 */
public class Calculation {
    private static final int[] NUMBERS_POSITIONS = {1, 2, 3};
    private Map<Integer, Integer> comNumbers;

    Calculation(Map<Integer, Integer> comNumbers) {
        this.comNumbers = comNumbers;
    }

    StrikeBall calcStrikeAndBall(Map<Integer, Integer> userNumbers) {
        StrikeBall strikeBall = new StrikeBall(0, 0);
        for (int numbersPositions : NUMBERS_POSITIONS) {
            if (comNumbers.get(numbersPositions).equals(userNumbers.get(numbersPositions))) {
                strikeBall.setStrike(strikeBall.getStrike() + 1);
            } else if (comNumbers.containsValue(userNumbers.get(numbersPositions))) {
                strikeBall.setBall(strikeBall.getBall() + 1);
            }
        }
        return strikeBall;
    }

    boolean checkThreeStrike(StrikeBall strikeBall) {
        return strikeBall.getStrike() != 3;
    }
}
