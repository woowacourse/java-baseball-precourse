package com.github.callmewaggs.javabaseballprecourse;

import java.util.*;

public class Computer {
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void generateRandomBall() {
        LinkedHashSet<Integer> candidates = new LinkedHashSet<>();

        while (candidates.size() < 3) {
            int number = (int) (Math.random() * 1000) % 9 + 1;
            candidates.add(number);
        }

        this.numbers = new ArrayList<>(candidates);
    }
}
