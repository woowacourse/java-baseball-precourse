/*
 * Computer.java            0.9       2020-11-25
 *
 * Copyright (c) 2020 Yeonwoo Cho
 * ComputerScience, ProgrammingLanguage, Java, Seoul, KOREA
 * All rights reserved
 */

package baseball.domain;

import java.util.List;

/**
 * 연산하는 역할을 맡은 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 11월 25일
 */
public class Computer {
    private int countsOfStrike = 0;
    private int countsOfBall = 0;

    public Computer() {
    }

    public void calculateResult(List<Integer> inputNumbers, List<Integer> randomNumber) {
        for (int i = 0; i < inputNumbers.size(); i++) {
            Integer numberInInputNumbers = inputNumbers.get(i);
            if (numberInInputNumbers.equals(randomNumber.get(i))) {
                this.countsOfStrike++;
            } else if (randomNumber.stream().anyMatch(j -> j.equals(numberInInputNumbers))) {
                this.countsOfBall++;
            }
        }
    }

    public int getCountsOfBall() {
        return this.countsOfBall;
    }

    public int getCountsOfStrike() {
        return this.countsOfStrike;
    }
}
