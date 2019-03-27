package com.nekisse.baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    public static final int BASEBALL_GAME_LIMIT_NUM = 3;
    public static final int BASEBALL_MIN_NUMBER = 1;
    public static final int BASEBALL_MAX_NUMBER = 9;

    public List<Integer> createBaseballGameNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = BASEBALL_MIN_NUMBER; i <= BASEBALL_MAX_NUMBER; i++) {
            numbers.add(i);
        }
        return getRandomNumbers(numbers);
    }


    private List<Integer> getRandomNumbers(List<Integer> numbers) {
        List<Integer> gameNumbers = new ArrayList<>();
        shuffleNum(numbers);
        for (int i = 0; i < BASEBALL_GAME_LIMIT_NUM; i++) {
            gameNumbers.add(numbers.get(i));
        }
        System.out.println("gameRandomNumbers = " + gameNumbers);
        return gameNumbers;
    }

    protected void shuffleNum(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }
}




