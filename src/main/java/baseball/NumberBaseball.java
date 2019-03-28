/*
 * NumberBaseball
 *
 * ver 1.0
 *
 * 2019/03/28
 *
 * Copyright 2019. Jieun Jeong. All ringts reserved.
 */

package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class NumberBaseball {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();

        // 1~9 서로 다른 세 숫자 선정
        while(numbers.size()!=3) {
            numbers.add((int)(Math.random() * 9 + 1));
        }

        ArrayList<Integer> correctAnswer = new ArrayList<>(numbers);
        Collections.shuffle(correctAnswer);
    }
}
