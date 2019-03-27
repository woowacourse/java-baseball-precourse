/*
 *  클래스 이름 : BaseballGame.java
 *
 *  버전 정보 :
 *
 *  날짜 : 2019-03-27
 *
 *  저작권 : 이예지
 */

package com.woowacourse.baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    static final int RESTART = 1;
    static final int FINISH = 2;

    public static void main(String[] args) {
        do {
            playGame();
        } while (restartOrFinishGame()==RESTART);
    }

    /* 1. 컴퓨터의 수(정답)를 선택하는 기능. */
    static List<Integer> createRandomNumber(){

        List<Integer> computerNumber = new ArrayList<>();
        Random r = new Random();
        int number;

        for (int i = 0; i < 3; ++i) {
            number = (r.nextInt(8) + 1);

            if (computerNumber.contains(number)) {
                i--;
                continue;
            }

            System.out.println("컴퓨터의 숫자 "+i+"번째 수 : " + number);

            computerNumber.add(number);
        }

        return computerNumber;
    }

    /* 2. 사용자의 수를 입력받는 기능 */
    static int inputPlayerNumber(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자를 입력해주세요.");

        String s = scanner.nextLine();

        System.out.println("s는"+s);

        if (s.matches("[1-9]{3}")) {
           // scanner.close();
            return Integer.parseInt(s);
        } else {
            System.out.println("올바르지 않은 형식입니다. 3개의 숫자를 입력해주세요.");
           // scanner.close();
            return inputPlayerNumber();
        }
    }

    /* 3. 컴퓨터의 수와 사용자가 입력한 수를 비교하는 기능 */
    static Result compareNumber(List<Integer> computerNumber, int playerNumber) {

        int n;
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = computerNumber.size() - 1; i >= 0; --i) {
            n = playerNumber % 10;
            playerNumber /= 10;

            if (n == computerNumber.get(i)) {
                strikeCount++;
            } else if (computerNumber.contains(n)) {
                ballCount++;
            }
        }

        return new Result(strikeCount, ballCount);
    }

    /* 4. 게임이 종료된 후 게임을 다시 시작하거나 완전히 끝내는 기능 */
    static int restartOrFinishGame(){

        Scanner scanner = new Scanner(System.in);
        int restartOrFinish = 0;
        String s;

        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            s = scanner.nextLine();

            if (!s.matches("[1,2]")) {
                continue;
            }

            restartOrFinish = Integer.parseInt(s);

            if (restartOrFinish == RESTART) {
                System.out.println("게임을 새로 시작합니다.");
                break;
            } else if (restartOrFinish == FINISH) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        } while (!(restartOrFinish == RESTART || restartOrFinish == FINISH));

        return restartOrFinish;
    }

    /* 5. 게임을 진행하는 기능 */
    static void playGame(){

        List<Integer> computerNumber = createRandomNumber();
        int playerNumber;
        Result compareResult;

        do {
            playerNumber = inputPlayerNumber();
            compareResult = compareNumber(computerNumber, playerNumber);
            System.out.println(compareResult.toString());
        } while (compareResult.getStrikeCount()!=3);

    }

}