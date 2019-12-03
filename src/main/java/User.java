/**
 * User.java
 * 아직 리팩토링 중...
 * 우아한테크코스 프리코스 1주차.
 * Original code https://github.com/hotheadfactory/java-baseball-precourse
 * Version: v0.0.1, 2019.11.29 (c) 정회형
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class User {
    public List<Integer> inputNumber(int digitNumber) {
        Scanner sc = new Scanner(System.in);
        List<Integer> digits = new ArrayList<>();
        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            digits = toArray(sc.nextInt());
            if (verifyUnique(digits, digitNumber) == true) {
                break;
            }
            System.out.println("다시 입력해 주세요.");
        }
        return digits;
    }

    public boolean verifyUnique(List<Integer> digits, int digitNumber) {
        if (digits.size() != digitNumber) {
            return false;
        }
        boolean[] index = new boolean[10];
        for (int i = 0; i < digits.size(); i++) {
            if (index[digits.get(i)] == true || digits.get(i) == 0) {
                return false;
            }
            index[digits.get(i)] = true;
        }
        return true;
    }

    public List<Integer> toArray(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number != 0) {
            digits.add(0, number % 10);
            number = number / 10;
        }
        return digits;
    }
}
