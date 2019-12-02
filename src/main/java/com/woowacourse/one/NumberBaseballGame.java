package com.woowacourse.one;

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;

/**
 * 기능 구현 목록
 * 1. 랜덤변수를 만드는 메소드
 * 2. 플레이어의 입력을 받는 메소드
 * 3. 스트라이크 횟수와 볼 횟수를 구하는 메소드
 * 4. 스트라이크 횟수와 볼 횟수를 출력하는 메소드
 * 5. 게임이 끝났을 때 새로 시작하거나 종료하는 메소드
 *
 * @author aegis1920
 * @className NumberBaseball
 * @date 2019.12.02
 * @version 1.0
 *
 */
public class NumberBaseballGame {

    /** 3자리의 숫자 야구 게임이므로 3자리수를 위한 DIGIT 상수 */
    private static final int DIGIT = 3;

    /** 2를 입력했을 때 게임을 종료하기 위한 상수 */
    private static final int END = 2;

    /**
     * 원소가 서로 다른 랜덤 배열을 만드는 메소드입니다. boolean배열을 체크해가면서 전에 있던 값은 넣지 않아 서로 다른 값이 들어가도록
     * 했습니다.
     *
     * @param randNumList
     */
    public static void makeRandNum(int[] randNumList) {

        int randNum = (int) (Math.random() * 9) + 1;

        boolean[] checkRandList = new boolean[10];

        for (int i = 0; i < DIGIT; i++) {

            while (checkRandList[randNum]) {
                randNum = (int) (Math.random() * 9) + 1;
            }

            checkRandList[randNum] = true;

            randNumList[i] = randNum;
        }

    }

    /**
     * 플레이어로부터 숫자를 입력받아 배열로 리턴시켜주는 메소드입니다. 3자리가 아니거나 같은 숫자가 있다면 while문으로 다시 입력해달라고
     * 재요청합니다.
     *
     * @param sc
     * @return playerNumList
     */
    public static int[] inputPlayerNum(Scanner sc) {

        System.out.println("숫자를 입력해주세요 : ");

        int playerNum = sc.nextInt();

        while (true) {

            if (!checkNumDigit(playerNum)) {
                System.out.println("숫자를 3자리로 다시 입력해주세요!");
                playerNum = sc.nextInt();
                continue;
            }

            if (!checkNumDuplicate(playerNum)) {
                System.out.println("서로 다른 숫자로 다시 입력해주세요!");
                playerNum = sc.nextInt();
                continue;
            }

            break;

        }

        int[] playerNumList = new int[DIGIT];

        String temp = playerNum + "";

        for (int i = 0; i < DIGIT; i++) {
            playerNumList[i] = temp.charAt(i) - '0';
        }

        return playerNumList;
    }

    /**
     * 3자리(digit)인지 체크하는 메소드입니다.
     *
     * @param playerNum
     * @return boolean
     */
    public static boolean checkNumDigit(int playerNum) {

        int playerNumLength = (playerNum + "").length();

        if (playerNumLength == DIGIT) {
            return true;
        }

        return false;

    }

    /**
     * 중복되어 있는 숫자가 있는지 체크하는 메소드입니다. HashSet으로 중복체크를 해줍니다.
     *
     * @param playerNum
     * @return boolean
     */
    public static boolean checkNumDuplicate(int playerNum) {

        HashSet<Integer> hs = new HashSet<Integer>();

        while (playerNum != 0) {
            if (hs.contains(playerNum % 10)) {
                return false;
            } else {
                hs.add(playerNum % 10);
                playerNum /= 10;
            }
        }

        return true;

    }

    /**
     * 입력받은 randNumList와 playerNumList를 비교하기 위한 반복 메소드입니다.
     *
     * @param randNumList
     * @param playerNumList
     * @return strikeAndBallCnt
     */
    public static int[] repeatNumList(int[] randNumList, int[] playerNumList) {

        int[] strikeAndBallCnt = new int[2];

        for (int i = 0; i < DIGIT; i++) {
            for (int j = 0; j < DIGIT; j++) {
                calculateStrikeAndBall(i, j, randNumList, playerNumList, strikeAndBallCnt);
            }
        }

        return strikeAndBallCnt;
    }

    /**
     * strike와 ball의 개수를 계산해주는 메소드입니다.
     *
     * @param i
     * @param j
     * @param randNumList
     * @param playerNumList
     * @param strikeAndBallCnt
     */
    public static void calculateStrikeAndBall(int i, int j, int[] randNumList, int[] playerNumList,
                                              int[] strikeAndBallCnt) {
        if (randNumList[i] == playerNumList[j]) {
            if (i == j) {
                strikeAndBallCnt[0]++;
            } else {
                strikeAndBallCnt[1]++;
            }
        }
    }

    /**
     * 스트라이크와 볼의 출력을 위한 메소드입니다.
     *
     * @param strikeCnt
     * @param ballCnt
     */
    public static void printStrikeAndBall(int strikeCnt, int ballCnt) {
        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        } else if (strikeCnt > 0 && ballCnt == 0) {
            System.out.println(strikeCnt + "스트라이크");
        } else if (strikeCnt == 0 && ballCnt > 0) {
            System.out.println(ballCnt + "볼");
        } else {
            System.out.println(strikeCnt + "스트라이크 " + ballCnt + "볼");
        }
    }

    /**
     * 3 strike일 경우 게임을 종료하거나 다시 시작하는 것을 구현한 메소드입니다.
     *
     * @param strikeCnt
     * @param randNumList
     * @param sc
     * @return
     */
    public static boolean endGame(int strikeCnt, int[] randNumList, Scanner sc) {

        if (strikeCnt == DIGIT) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int userInput = sc.nextInt();

            if (userInput == END) {
                System.out.println("게임을 종료합니다.");
                return true;
            } else {
                System.out.println("게임을 다시 시작합니다.");
                makeRandNum(randNumList);
                return false;
            }

        }

        return false;
    }

    public static void main(String[] args){
        System.out.println("hello world");
    }
}
