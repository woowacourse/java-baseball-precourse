/**
 * User.java
 * 아직 리팩토링 중...
 * 우아한테크코스 프리코스 1주차.
 * Original code https://github.com/hotheadfactory/java-baseball-precourse
 * Version: v0.0.1, 2019.11.29 (c) 정회형
 */

import java.util.Scanner;
import java.util.stream.Stream;

public class User {
    public int[] inputNumber(int digitNumber) {
        Scanner sc = new Scanner(System.in);
        int[] digits;
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

    public boolean verifyUnique(int[] digits, int digitNumber) {
        if (digits.length != digitNumber) {
            return false;
        }
        boolean[] index = new boolean[10];
        for (int i = 0; i < digits.length; i++) {
            if (index[digits[i]] == true || digits[i] == 0) {
                return false;
            }
            index[digits[i]] = true;
        }
        return true;
    }

    public int[] toArray(int number) {
        int[] digits = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
        return digits;
    }
}
