package com.github.callmewaggs.javabaseballprecourse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void generateRandomBall() {
        Set<Integer> candidates = new HashSet<>();

        while (candidates.size() < 3) {
            int number = (int) (Math.random() * 1000) % 9 + 1;
            candidates.add(number);
        }

        this.numbers = new ArrayList<>(candidates);
    }
}
