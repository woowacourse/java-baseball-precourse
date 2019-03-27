package com.nekisse.baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateRandomNumber {
    static final int BASEBALL_GAME_LIMIT_NUM = 3;
    private static final int BASEBALL_MIN_NUMBER = 1;
    private static final int BASEBALL_MAX_NUMBER = 9;

    public BaseballNumbers createBaseballGameNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = BASEBALL_MIN_NUMBER; i <= BASEBALL_MAX_NUMBER; i++) {
            numbers.add(i);
        }
        return getRandomNumbers(numbers);
    }


    private BaseballNumbers getRandomNumbers(List<Integer> numbers) {
        List<Number> gameNumbers = new ArrayList<>();
        shuffleNum(numbers);
        for (int i = 0; i < BASEBALL_GAME_LIMIT_NUM; i++) {
            gameNumbers.add(Number.getNumber(numbers.get(i)));
        }
        System.out.println("gameRandomNumbers = " + gameNumbers);
        return new BaseballNumbers(gameNumbers);
    }

    protected void shuffleNum(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }
}




