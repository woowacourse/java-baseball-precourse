/**
 * Baseball.java
 * 아직 리팩토링 중...
 * 우아한테크코스 프리코스 1주차.
 * Original code https://github.com/hotheadfactory/java-baseball-precourse
 * Version: v0.0.1, 2019.11.29 (c) 정회형
 */

import java.util.Scanner;
import java.util.stream.Stream;


public class Baseball {
    private static int digitNumber = 3;

    public void init() {
        int[] userInput, computerInput, strikeBall;
        Computer computer = new Computer();
        Referee referee = new Referee();
        userInput = inputNumber();
        computerInput = computer.pickRandomNumber(digitNumber);
        while (true) {
            strikeBall = referee.countStrikeBall(userInput, computerInput);
            if (printStrikeBall(strikeBall)) break;
            userInput = inputNumber();
        }
    }

    private boolean printStrikeBall(int[] strikeBall) {
        if (strikeBall[0] != 0) {
            System.out.printf("%d스트라이크 ", strikeBall[0]);
        }
        if (strikeBall[1] != 0) {
            System.out.printf("%d볼", strikeBall[1]);
        }
        if (strikeBall[0] == 0 && strikeBall[1] == 0) {
            System.out.printf("낫싱");
        }
        System.out.println();

        if (strikeBall[0] == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private int[] inputNumber() {
        Scanner sc = new Scanner(System.in);
        int[] digits;
        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            digits = toArray(sc.nextInt());
            if (verifyUniquity(digits) == true) {
                break;
            }
            System.out.println("다시 입력해 주세요.");
        }
        return digits;
    }

    private boolean verifyUniquity(int[] digits) {
        if (digits.length != digitNumber) return false;
        int[] dictionary = new int[10];
        for (int i = 0; i < digits.length; i++) {
            if (dictionary[digits[i]] == 1 || digits[i] == 0) {
                return false;
            }
            dictionary[digits[i]] = 1;
        }
        return true;
    }

    public int[] toArray(int number) {
        int[] digits = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
        return digits;
    }
}
