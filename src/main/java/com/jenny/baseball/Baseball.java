package com.jenny.baseball;

import java.util.Scanner;

public class Baseball implements Gamable {

    Scanner sc = new Scanner(System.in);
    /*
     * 임의로 중복이 없는 1~9 숫자로 세자리 수를 만든다.
     */
    @Override
    public int[] createNumber() {

        int[] num = new int[3];


        for(int i = 0 ; i < 3 ; i++){
            makeDigits:
            while(true){

                num[i] = (int)(Math.random()*10);

                if(num[i] == 0){
                    continue makeDigits;
                }
                for(int prev = 0 ; prev < i ; prev++ ){
                    if(num[prev] == num[i]){
                        continue makeDigits;
                    }
                }
                break;
            }
        }

        return num;
    }

    @Override
    public void showAskMsg() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void showResult() {

    }

    @Override
    public void showSuccessMsg() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public void showRestartMsg() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    /*
     * 사용자로부터 숫자를 입력받는 메서드
     * 유효한 숫자가 들어올때까지 요구한다
     */
    @Override
    public int[] getNumber() {
        int number = 0;

        do{
            number = sc.nextInt();

        }while(!isValidNumber(number));

        int[] userNum = new int[3];
        userNum[0] = number/100;
        userNum[1] = (number%100)/10;
        userNum[2] = number%10;

        return userNum;
    }

    @Override
    public boolean isValidNumber(int number) {
        return false;
    }

    @Override
    public boolean judgeNumber(int[] userNum, int[] answer) {
        return false;
    }

    @Override
    public int wantRestart() {
        return 0;
    }

    @Override
    public void run() {

        int[] answer = createNumber();

        while(true){

            showAskMsg();
            int[] userNum = getNumber();

            if(judgeNumber(userNum, answer) == true){
                break;
            }
        }
    }
}
