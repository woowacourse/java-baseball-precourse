/*
 * 클래스 이름: NumberBaseballGame
 * 버전 정보: v1.0
 * 날짜: 11월 27일
 * 저작권 주
 */

import java.util.Scanner;
import java.util.Random;

public class NumberBaseballGame {
    public static void main(String[] args) {
        Game();
    }

    public static void Game() {

        /* 랜덤으로 정답이 되는 세 숫자 배정 */
        int answer[] = setAnswer();


    }

    public static int[] setAnswer() {
        Random random = new Random();
        int answer[] = new int[3];

        while (answer[0] == 0) {
            answer[0] = random.nextInt(10);
        }
        while (answer[0] == answer[1] || answer[1] == 0) {
            answer[1] = random.nextInt(10);
        }
        while (answer[0] == answer[2] || answer[1] == answer[2] || answer[2] == 0) {
            answer[2] = random.nextInt(10);
        }
        System.out.println("answer[0]: " + answer[0]);
        System.out.println("answer[1]: " + answer[1]);
        System.out.println("answer[2]: " + answer[2]);

        return answer;
    }
}
