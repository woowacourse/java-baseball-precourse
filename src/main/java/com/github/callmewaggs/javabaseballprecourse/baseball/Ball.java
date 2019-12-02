package com.github.callmewaggs.javabaseballprecourse.baseball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Ball {
    private List<Integer> numbers;

    public Ball(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Ball(LinkedHashSet<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
