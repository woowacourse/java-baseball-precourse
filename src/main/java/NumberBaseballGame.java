/*
 * 클래스 이름: NumberBaseballGame
 * 버전 정보: v1.0
 * 날짜: 11월 29일
 * 저작권 주의
 */

import java.util.Scanner;
import java.util.Random;

public class NumberBaseballGame {
    static int strike;
    static int ball;

    public static void main(String[] args) {
        Game();
    }

    public static void Game() {
        strike = 0;
        ball = 0;
        Scanner sc = new Scanner(System.in);

        /* 랜덤으로 정답이 되는 세 숫자 배정 */
        int answer[] = setAnswer();

        while (strike != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            int userInput = sc.nextInt();
            compare(answer, userInput);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userDecision = sc.nextInt();
        if (userDecision == 2) {
            System.out.println("게임이 종료되었습니다.");
        }
        else if (userDecision == 1) {
            Game();
        }
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

    public static int[] numberIntoArray(int userInput) {
        int[] userInputArray = new int[3];
        userInputArray[2] = userInput % 10;
        userInput /= 10;
        userInputArray[1] = userInput % 10;
        userInput /= 10;
        userInputArray[0] = userInput % 10;
        return userInputArray;
    }

    public static void count(int answerIndex, int inputIndex, int[] answer, int[] userInputArray) {
        if (answer[answerIndex] == userInputArray[inputIndex]) {
            if (answerIndex == inputIndex) {
                strike++;
            }
            else {
                ball++;
            }
        }
    }

    public static void compare(int[] answer, int userInput) {
        strike = 0;
        ball = 0;

        int[] userInputArray = numberIntoArray(userInput);

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                count(i, j, answer, userInputArray);
            }
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        else if (strike == 0) {
            System.out.println(ball + "볼");
        }
        else if (ball == 0) {
            System.out.println(strike + " 스트라이크");
        }
        else {
            System.out.println(strike + " 스트라이크 " + ball + "볼");
        }

    }

}
