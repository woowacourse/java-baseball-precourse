package com.cjw.baseball;

import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {

    public static final int RANGE = 9;
    public static final int ANSWER_NUM = 3;
    private int computerAns[];                          //컴퓨터가 가질 숫자 리스트
    private Random random;
    private Scanner scan = new Scanner(System.in);

    public static void main(String[] args){

        BaseBallGame game = new BaseBallGame();
        game.init();
        game.startGame();

    }

    /**
     * init()
     * 컴퓨터가 가질 숫자를 랜덤으로 설정하는 함
     */

    private void init(){
        int nowIdx = 0;
        boolean check;

        random = new Random();
        computerAns = new int[ANSWER_NUM];

        /**
         * 상대방의 숫자가 서로 다른 세 수가 될때까지 반복
         */
        while(nowIdx < ANSWER_NUM){
            computerAns[nowIdx] = random.nextInt(RANGE) + 1;
            check = overlapCheck(nowIdx, computerAns[nowIdx]);

            if(!check){
                nowIdx++;
            }
        }

        /*for(int i=0; i<3; i++){
            System.out.println(computerAns[i]);
        }*/
    }

    private boolean overlapCheck(int idx, int val){
        for(int i = 0; i < idx; i++){
            if(computerAns[i] == val){
                return true;
            }
        }
        return false;
    }

    private void startGame(){
        while(true){
            int myAns[];
            boolean check;

            myAns = requestNumber();                    //입력 받은 숫자 저장
            for(int i=0; i<3; i++){
                System.out.println(myAns[i]);
            }
            break;
        }
    }

    /**
     * requestNumber
     * 숫자를 입력받는 기능을 하는 함
     */

    private int[] requestNumber(){
        int response[] = new int[ANSWER_NUM];
        boolean check;
        String ans;

        while(true) {
            System.out.println("숫자를 입력해주세요 : ");

            ans = scan.nextLine();
            check = requestCheck(ans);

            if(check){
                break;
            }else{
                System.out.println("숫자를 제대로 입력해주세요");
            }
        }

        for (int i = 0; i < ANSWER_NUM; i++) {
            response[i] = ans.charAt(i) - '0';
        }

        return response;
    }

    /**
     * requestCheck, requestOverlapCheck
     * 각 자리 숫자와 다른 자리 숫자를 비교하여 같은지 판별하는 메소드
     */

    private boolean requestCheck(String req){
        if(req.length() != 3){                          //입력받은 문자길이가 3이면 제대로 입력한 것
            return false;
        }
        for(int i = 0; i < ANSWER_NUM; i++){            //각 자리의 숫자와 중복 숫자 겹치는지 확인
            if(!requestOverlapCheck(req, i)){
                return false;
            }
        }
        return true;
    }

    private boolean requestOverlapCheck(String req, int idx){
        for(int i=0; i<ANSWER_NUM; i++){
            if((i != idx) && (req.charAt(i) == req.charAt(idx))){
                return false;
            }
        }
        return true;
    }
}
