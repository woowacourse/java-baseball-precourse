/**
 * 클래스 이름      PlayGame
 * 버전 정보        1.0
 * 날짜            2019.12.01
 * 저작권          YebinK
 */

import java.util.Scanner;

public class PlayGame {

    PlayerInput p = new PlayerInput();
    int [] answer = new int[3];
    int [] userInput = new int[3];

    int strikeCount = 0;
    int ballCount = 0;

    public void playCmd() {
        RandomNumber rn = new RandomNumber();
        answer = rn.setNumber();

        while (strikeCount != 3) {
            initializeCount();
            userInput = p.getInput();
            compare();
            printResult();
        }
    }

    public void compare() {
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                count(i, j);
            }
        }
    }

    public void count(int i, int j) {
        if (answer[i] == userInput[j] && i == j) strikeCount++;
        if (answer[i] == userInput[j] && i != j) ballCount++;
    }

    public void printResult() {

        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart();
            return;
        }

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return;
        }

        if (ballCount == 0) {
            System.out.println(strikeCount + " 스트라이크");
            return;
        }

        if (strikeCount == 0) {
            System.out.println(ballCount + " 볼");
            return;
        }

        System.out.println(strikeCount + " 스트라이크 " + ballCount + " 볼");
    }

    public void initializeCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    public void restart() {
        Scanner sc = new Scanner(System.in);
        int cmd = sc.nextInt();

        if (cmd == 1) {
            initializeCount();
            playCmd();
        }
        return;
    }
}