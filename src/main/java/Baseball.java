/**
 * baseball.java
 * 아직 리팩토링 중...
 * 우아한테크코스 프리코스 1주차.
 * Original code https://github.com/hotheadfactory/java-baseball-precourse
 * Version: v0.0.1, 2019.11.29 (c) 정회형
 */


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;


public class Baseball {
    private static int digitNumber = 3;
    public void init() {
        int[] userInput, computerInput, strikeBall;
        Computer computer = new Computer();
        Referee referee = new Referee();
        System.out.println("자바 숫자야구 게임!");
        userInput = inputNumber();
        computerInput = computer.pickNumber(digitNumber);
        while(true) {
            strikeBall = referee.countStrikeBall(userInput, computerInput);
            System.out.println(Arrays.toString(strikeBall));
            if (strikeBall[0] == 3) {
                System.out.println("정답입니다!");
                break;
            }
            userInput = inputNumber();
        }

    }
    // 숫자를 입력받는다. 추후에 View로 분리
    public int[] inputNumber() {
        int[] userInput;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("세 자리 숫자를 입력하세요: ");
            userInput = inputAnswer(sc.nextInt());
            if (userInput != null) {
                break;
            }
            System.out.println("다시 입력해 주세요.");
        }
        return userInput;
    }

    // 숫자를 배열로 바꾸고 검증한다.
    public int[] inputAnswer(int number) {
        int[] digits = toArray(number);
        if (!verify(digits)) return null;               // 먼저 중복 검사를 한다.
        System.out.println(Arrays.toString(digits));
        return digits;
    }

    // 모든 숫자가 unique해야 하므로 이를 테스트 한다.
    private boolean verify(int[] digits) {
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

    //n자리 int를 array로 바꾼다.
    public int[] toArray(int number) {
        // int의 각 자릿수를 나누어 배열에 저장하는 코드
        int[] digits = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
        return digits;
    }
}
