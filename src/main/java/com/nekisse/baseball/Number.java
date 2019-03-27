package com.nekisse.baseball;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Number {

    private final int number;

    private static final Map<Integer, Number> numbers = new HashMap<>();

    static {
        for (int i = 1; i <= 9; i++) {
            numbers.put(i, new Number(i));
        }
    }

    private Number(int number) {
        this.number = number;
    }

    public static Number getNumber(int number) {
        return Optional.ofNullable(numbers.get(number)).orElseThrow(() -> new IllegalArgumentException("1~9사이의 값만 허용됩니다."));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
