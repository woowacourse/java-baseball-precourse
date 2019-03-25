/*
 * BaseballGame
 *
 * 1.0.0
 *
 * 2019.03.25
 *
 * MIT
 */

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

/**
 * 숫자 야구 게임을 구현한 클래스 입니다.
 *
 * @version 1.0.0
 * @author changhoi
 */

public class BaseballGame {

    /* 게임을 이겼는지 졌는지를 판단해주는 함수입니다. */
     static boolean isWin(int strike) {
        if(strike == 3) return true;
        return false;
    }

    /* 컴퓨터가 임의로 3개의 1~9의 숫자를 생성해 저장한 배열을 리턴하는 함수입니다. */
     static int[] makeArray() {
        Random rand = new Random(System.currentTimeMillis());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = rand.nextInt(8) + 1;
        }
        return arr;
    }

    /* 사용자가 입력한 세 자리 숫자를 각 자리 별로 나누어 저장한 배열을 리턴하는 함수입니다. */
    static int[] inputArray(int val) {
        int[] arr = new int[3];
        for (int i = 2; i >= 0; i--) {
            arr[i] = val % 10;
            val /= 10;
        }
        return arr;
    }

    /* 스트라이크의 수를 리턴하는 함수입니다. */
    static int countStrike(int[] answer, int[] arr) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (arr[i] == answer[i])
                count++;
        }
        return count;
    }

    /**
     *  볼의 수를 리턴하는 함수입니다. 다만 스트라이크의 수를 포함한 수를 리턴합니다.
     *  배열을 정렬하기 때문에 countStrike() 함수 이후 사용해야 합니다.
     */
    static int countBall(int[] answer, int[] arr) {
        Arrays.sort(answer);
        int count = 0;
        for (int i : arr) {
            if (Arrays.binarySearch(answer, i) >= 0)
                count++;
        }
        return count;
    }

    /* 스트라이크와 볼 결과를 표시해주는 함수입니다. */
    static void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + " 볼");
        } else if (ball == 0) {
            System.out.println(strike + " 스트라이크");
        } else {
            System.out.println(strike + " 스트라이크 " + ball + " 볼");
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        while(true) {
            int[] answer = makeArray();
            boolean win = false;
            while(!win) {
                System.out.print("숫자를 입력해주세요 : ");
                int val = stdIn.nextInt();
                int[] arr = inputArray(val);

                int strike = countStrike(answer, arr);
                int ball = countBall(answer, arr);
                ball -= strike;

                printResult(strike, ball);

                win = isWin(strike);
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            int re = stdIn.nextInt();
            if (re == 2)
                break;
        }
    }
}
