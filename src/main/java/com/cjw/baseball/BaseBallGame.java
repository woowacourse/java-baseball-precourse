package com.cjw.baseball;

import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {

    public static final int RANGE = 9;
    public static final int ANSWER_NUM = 3;
    private int computerAns[];
    private Random random;

    public static void main(String[] args){

        BaseBallGame game = new BaseBallGame();
        game.init();

    }
    private void init(){
        int nowIdx = 0;
        boolean check;

        random = new Random();
        computerAns = new int[ANSWER_NUM];

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
}
