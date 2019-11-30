/*
 * @(#)BaseBallGame.java
 *
 * 버전 : 1.0
 *
 * 날짜 : 2019.11.30
 */
package com.cjw.baseball;

import java.util.Random;
import java.util.Scanner;

/**
 * 우아한테크코스 프리코스 1주차 숫자 야구 게임
 *
 * @version             1.0     2019.11.30
 * @author              최재우
 */

public class BaseBallGame {
    private static final int RANGE = 9;                 //1~9 범위를 정하기 위한 상수
    private static final int ANSWER_NUM = 3;            //답의 개수가 3으로 설정한 상수
    private static final int END_GAME = 2;              //게임 종료 상수
    private static final int RESTART_GAME = 1;          //게임 재시작 상수

    private int computerAns[];                          //컴퓨터가 가질 숫자 리스트
    private Random random;
    private Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        BaseBallGame game = new BaseBallGame();
        game.startGame();
    }

    /*
     * init()
     * 컴퓨터가 가질 숫자를 랜덤으로 설정하는 메소드
     */
    private void init() {
        int nowIdx = 0;
        boolean check;

        random = new Random();
        computerAns = new int[ANSWER_NUM];

        /**
         * 상대방의 숫자가 서로 다른 세 수가 될때까지 반복
         */
        while(nowIdx < ANSWER_NUM) {
            computerAns[nowIdx] = random.nextInt(RANGE) + 1;
            check = overlapCheck(nowIdx, computerAns[nowIdx]);

            if (!check) {
                nowIdx++;
            }
        }

        //printComputerValue();
    }
    /*
     * printComputerValue()
     * 컴퓨터 숫자 출력 메소드
     * 테스트 전
     */
    private void printComputerValue() {
        for(int i = 0; i < ANSWER_NUM; i++) {
            System.out.print(computerAns[i] + " ");
        }
        System.out.println("");
    }

    /**
     * overlapCheck()
     * 컴퓨터가 가질 숫자들의 중복 값 체크 메소
     * @param idx : 결정된 숫자 개수
     * @param val : 체크할 숫자
     * @return
     */
    private boolean overlapCheck(int idx, int val) {
        for(int i = 0; i < idx; i++) {                   //지금까지 결정된 숫자 들과 중복 비교
            if(computerAns[i] == val) {                  //숫자 중복
                return true;
            }
        }
        return false;
    }

    /**
     * startGame()
     * 야구 게임을 시작하는 메소드
     */
    private void startGame() {
        while(true) {
            init();
            progressGame();
            if(!requestRestart()) {                     //게임 종료
                break;
            }
        }
    }

    /**
     * progressGame()
     *
     */
    private void progressGame() {
        int myAns[];
        boolean checkAns;

        while(true) {
            myAns = requestNumber();                    //입력 받은 숫자 저장
            checkAns = answer(myAns);

            if(checkAns) {                              //답을 맞췄다면
                break;
            }
        }
    }

    private boolean requestRestart() {
        int req;
        boolean checkVal;

        while(true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            req = scan.nextInt();
            scan.nextLine();
            checkVal = checkRestartValue(req);

            if(checkVal) {
                break;
            }
        }

        if(req == RESTART_GAME) {                       //게임 다시 시작
            return true;
        } else {                                        //게임 종료
            return false;
        }
    }

    private boolean checkRestartValue(int val) {
        if((val == RESTART_GAME) || (val == END_GAME)) {
            return true;
        } else {
            System.out.println("제대로 된 숫자를 입력해주세요");
            return false;
        }
    }

    /**
     * requestNumber()
     * 정답 숫자를 입력받는 메소드
     */
    private int[] requestNumber() {
        int response[] = new int[ANSWER_NUM];
        boolean check;
        String ans;

        while(true) {
            System.out.println("숫자를 입력해주세요 : ");

            ans = scan.nextLine();
            check = requestCheck(ans);

            if(check) {
                break;
            } else {
                System.out.println("숫자를 제대로 입력해주세요");
            }
        }

        for (int i = 0; i < ANSWER_NUM; i++) {
            response[i] = ans.charAt(i) - '0';                     //아스키코드를 int로 변환
        }

        return response;
    }

    /**
     * requestCheck, requestOverlapCheck
     * 각 자리 숫자와 다른 자리 숫자를 비교하여 같은지 판별하는 메소드
     */
    private boolean requestCheck(String req) {
        if(req.length() != 3){                          //입력받은 문자길이가 3이면 제대로 입력한 것
            return false;
        }

        for(int i = 0; i < ANSWER_NUM; i++) {            //각 자리의 숫자와 중복 숫자 겹치는지 확인
            if(!requestOverlapCheck(req, i)) {
                return false;
            }
        }

        if(!requestRangeCheck(req)) {                   //각 자리 0~9 범위 입력 확인
            return false;
        }

        return true;
    }

    private boolean requestOverlapCheck(String req, int idx) {
        for(int i = 0; i < ANSWER_NUM; i++) {
            if((i != idx) && (req.charAt(i) == req.charAt(idx))) {
                return false;
            }
        }
        return true;
    }

    private boolean requestRangeCheck(String req) {
        for(int i = 0; i < ANSWER_NUM; i++) {
            if((req.charAt(i) < '0') || (req.charAt(i) > '9')) {
                return false;
            }
        }
        return true;
    }

    /**
     * answer, answerCheck
     * 입력받은 숫자와 컴퓨터 숫자를 비교하여 strike, ball 개수를 판별하는 메소
     * reqAns : 입력받은 숫자 리스트
     * idx : 비교할 문자 인덱
     */
    private boolean answer(int[] reqAns) {
        int strike = 0;
        int ball = 0;
        String rst;

        for(int i = 0; i < ANSWER_NUM; i++) {
            rst = answerCheck(reqAns, i);

            if(rst.equals("Strike")) {
                strike++;
            } else if (rst.equals("Ball")) {
                ball++;
            }
        }

        printAns(strike, ball);

        return endCheck(strike);
    }

    private String answerCheck(int[] reqAns, int idx) {

        for(int i = 0; i < ANSWER_NUM; i++) {
            if((idx == i) && (computerAns[i] == reqAns[idx])) {
                return "Strike";
            } else if (computerAns[i] == reqAns[idx]) {
                return  "Ball";
            }
        }
        return "Not";
    }

    private void printAns(int strike, int ball) {

        if(strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        if(strike > 0) {
            System.out.print(strike + " 스트라이크 ");
        }
        if(ball > 0) {
            System.out.print(ball + " 볼");
        }
        System.out.println("");
    }

    private boolean endCheck(int strike) {
        if(strike == ANSWER_NUM) {
            System.out.println("3개 숫자를 모두 맞추셨습니다! 게임 종료");
            return true;
        } else {
            return false;
        }
    }
}
