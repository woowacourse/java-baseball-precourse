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


public class baseball {

    private static int digitNumber = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("자바 숫자야구 게임!");
        while(true) {
            System.out.println("세 자리 숫자를 입력하세요: ");
            int answer = sc.nextInt();
            if(inputAnswer(answer)) { break; }
            System.out.println("다시 입력해 주세요.");
        }
    }
    public static boolean inputAnswer(int number) {
        int[] digits = toArray(number);
        if(!verify(digits)) return false;             // 먼저 중복 검사를 한다.
        System.out.println( Arrays.toString(digits) );

        return true;
    }

    // 모든 숫자가 unique해야 하므로 이를 테스트 한다.
    private static boolean verify(int[] digits) {
        if(digits.length != digitNumber) return false;
        int[] dictionary = new int[10];
        for(int i = 0; i < digits.length; i++) {
            if(dictionary[digits[i]] == 1) {
                return false;
            }
            dictionary[digits[i]] = 1;
        }
        return true;
    }

    public static int[] toArray(int number) {
        // int의 각 자릿수를 나누어 배열에 저장하는 코드
        int[] digits = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
        return digits;
    }





    public boolean deduplicate(int[] number) {
        return true;
    }
}
