/*
 * class: Baseball
 *
 * version: 1.0
 *
 * date: 2019.11.29
 *
 * 이 프로그램의 저작권은 joseph415에게 있습니다.
 * Copyright 2019.11.29
 */

package com.eunseok.BaseballGame;

import java.util.Random;
import java.util.Scanner;


/**
 * 게임을 구성해서 만드는 Baseball class.
 *
 * @author 정은석
 * @version 1.0 2019년 11월 29일
 */
public class Baseball {
    /**Baseballgame의 답을 나타내는 배열*/
    private static int[] ans = new int[3];
    /**사용자의 입력을 담는 배열*/
    private static int[] input = new int[3];

    /**
     * 클래스의 생성자. 클래스를 생성하면 게임의 정답이 ans배열에 저장.
     */
    public Baseball(){
        Random rand = new Random();
        for(int i=0;i<ans.length;i++) {
            ans[i] = rand.nextInt(9)+1;  // 1 ~ 9 난수생성
        }
    }

    /**사용자에게 입력을 받는 메소드.*/
    private void makeInput(){
        System.out.flush();
        System.out.print("숫자를 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);

        /**한자리씩 배열에 저장하기 위해 임시저장하는 temp변수*/
        int temp;
        temp = sc.nextInt();
        sc.nextLine();

        /**배열에 한자리씩 저장하기 위한 반복문*/
        for(int i=(input.length-1);i>=0;i--){
            input[i] = temp%10;
            temp/=10;
        }
    }

    /**
     * strike 와 ball을 구하는 매소드.
     * 사용자의 input과 답을 저장하고있는 ans를 비교.
     * 각 자리 위치가 같으면 strike++, 다른위치이면 ball++
     * @return strike 의 개수를 return. start()메소드의 무한루프 탈출조건.
     */
    private int check(){
        int strike = 0;
        int ball = 0;

        if (ans[0]==input[0]) {
            strike++;
        }
        if (ans[1]==input[1]) {
            strike++;
        }
        if (ans[2]==input[2]) {
            strike++;
        }

        if (ans[0]==input[1]||ans[0]==input[2]) {
            ball++;
        }
        if (ans[1]==input[0]||ans[1]==input[2]) {
            ball++;
        }
        if (ans[2]==input[0]||ans[2]==input[1]) {
            ball++;
        }
        System.out.println(strike + "스트라이크" + ball + "볼");

        return strike;
    }

    /**
     * 게임을 시작하는 start() 메소드
     */
    public void start(){
        /**strike개수를 리턴받는 변수.*/
        int checkStrike = 0;

        while (true) {
            makeInput();
            checkStrike = check();
            if(checkStrike == 3) {

                /**check()에서 받은 strike개수가 3개일때 무한루프 탈출.*/
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}