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
import java.util.Scanner;

public class NumberBaseball {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();

        // 1~9 서로 다른 세 숫자 선정
        while (numbers.size()!=3) {
            numbers.add((int)(Math.random() * 9 + 1));
        }

        ArrayList<Integer> correctAnswer = new ArrayList<>(numbers);
        Collections.shuffle(correctAnswer);

        // 사용자가 유추한 정답 입력
        String result = "";

        while (!result.equals("3스트라이크")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("숫자를 입력해주세요 : ");
            int userAnswer = scanner.nextInt();

            result = "3스트라이크";
        }
    }
}
