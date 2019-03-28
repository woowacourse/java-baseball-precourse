/*
 * @(#)Game.java          2019/03/28
 *
 * Copyright (c) 2019 Seungwoo Lee.
 * All rights reserved.
 *
 */

package com.baseball.game;

import com.baseball.count.*;
import com.baseball.input.*;

import java.util.Scanner;

/**
 * 숫자 야구 게임을 실행하고 컴퓨터의 숫자와 본인의 숫자의 비교 결과가 3스트라이크일 때까지
 * 힌트를 제공해주며 3스트라이크일 시, 게임을 완전히 종료하거나 다시 새로 시작하는 클래스입니다.
 *
 * @version         1.00 2019년 3월 28일
 *
 * @author          이승우
 */
public class Game {

    /**
     * 컴퓨터가 조건에 맞는 숫자를 생성하여 배열을 담기 위한 객체
     *
     * @see #main(String[])
     */
    private static ComputerNum computerNum = new ComputerNum();

    /**
     * 자신이 조건에 맞는 숫자를 입력하여 배열에 담기 위한 객체
     *
     * @see #beforeCorrect()
     */
    private static MyNum myNum = new MyNum();

    /**
     * 컴퓨터의 숫자와 자신이 입력한 숫자에서의 strike의 개수를 알아내기 위한 객체
     *
     * @see #beforeCorrect()
     * @see #afterCorrect()
     * @see #tellCount()
     */
    private static Strike strike = new Strike();

    /**
     * 컴퓨터의 숫자와 자신이 입력한 숫자에서의 ball의 개수를 알아내기 위한 객체
     *
     * @see #beforeCorrect()
     * @see #tellCount()
     */
    private static Ball ball = new Ball();

    /**
     * 컴퓨터 생성한 숫자의 각 자릿수를 담을 배열
     *
     * @see #main(String[])
     */
    private static int[] cNum = new int[3];

    /**
     * 자신이 입력한 숫자의 각 자릿수를 담을 배열
     *
     * @see #beforeCorrect()
     */
    private static int[] maNum = new int[3];

    /**
     * 컴퓨터의 숫자와 본인이 입력한 숫자를 비교한 스트라이크의 개수
     *
     * @see #beforeCorrect()
     * @see #afterCorrect()
     * @see #tellCount()
     */
    private static int strikeCnt;

    /**
     * 컴퓨터의 숫자와 본인이 입력한 숫자를 비교한 볼의 개수
     *
     * @see #beforeCorrect()
     * @see #tellCount()
     */
    private static int ballCnt;

    /**
     * 게임을 완전히 끝낼 지, 다시 새로 시작할 지 결정하는 변수
     *
     * @see #main(String[])
     * @see #endOrNot()
     */
    private static int end;

    /**
     * cNum에 컴퓨터의 숫자를 자릿수 별로 담고
     * 자신이 입력한 숫자와 비교하여
     * 스트라이크, 볼 개수 혹은 낫싱을 3스트라이크가 될 때까지 출력하고
     * end 값을 통해 게임을 완전히 끝낼 지, 다시 시작할 지 결정
     *
     * @param args
     * @see com.baseball.input.ComputerNum
     * @see #beforeCorrect()
     * @see #afterCorrect()
     * @see #end
     * @see #cNum
     */
    public static void main(String args[]) {
        while (true) {
            end = 0;
            cNum = computerNum.getCNum();

            beforeCorrect();
            afterCorrect();

            if (end == 2) {
                return;
            }
        }
    }

    /**
     * 컴퓨터 숫자와 비교할 숫자를 입력하여 maNum에 담는다
     * 스트라이크와 볼의 개수를 구하고 출력한다
     * 스트라이크 개수가 3이 될 때까지 반복한다
     *
     * @see com.baseball.input.MyNum
     * @see com.baseball.count.Strike
     * @see com.baseball.count.Ball
     * @see #tellCount()
     * @see #maNum
     * @see #strikeCnt
     * @see #ballCnt
     */
    private static void beforeCorrect() {
        do {
            System.out.print("숫자를 입력해주세요: ");
            maNum = myNum.getMyNum();
            strikeCnt = strike.countStrike(cNum, maNum);
            ballCnt = ball.countBall(cNum, maNum);
            tellCount();

        } while (strikeCnt != 3);
    }

    /**
     * 3스트라이크가 되면 아래의 문장을 출력하고
     * 다시 시작할 지 완전히 끝낼 지 결정한다
     *
     * @see #endOrNot()
     * @see #strikeCnt
     */
    private static void afterCorrect() {
        System.out.println(strikeCnt + "개의 숫자를 모두 맞히셨습니다! 게임 종료");

        endOrNot();
    }

    /**
     * 컴퓨터 숫자와 내가 입력한 숫자를 비교하여
     * 스트라이크 개수, 볼 개수 혹은 낫싱 임을 출력한다
     *
     * @see #strikeCnt
     * @see #ballCnt
     */
    private static void tellCount() {
        if (strikeCnt != 0) {
            System.out.print(strikeCnt + " 스트라이크 ");
        }

        if (ballCnt != 0) {
            System.out.println(ballCnt + "볼");
        } else if (strikeCnt != 0) {
            System.out.println();
        }

        if ((strikeCnt == 0) && (ballCnt == 0)) {
            System.out.println("낫싱");
        }
    }

    /**
     * 숫자 1 또는 2를 입력받아 end에 할당한다
     *
     * @see #end
     */
    private static void endOrNot() {
        Scanner input = new Scanner(System.in);

        while ((end != 1) && (end != 2)) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            end = input.nextInt();
        }
    }
}
