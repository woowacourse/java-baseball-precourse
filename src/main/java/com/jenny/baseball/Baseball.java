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
        System.out.println("숫자를 입력해주세요.");
    }

    /*
     * judgeNumber의 판단 결과에 따라 결과를 출력해주는 메서드
     */
    @Override
    public void showResult(int strike, int ball) {
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        }else{
            if(strike > 0){
                System.out.print(strike + " 스트라이크 ");
            }
            if(ball > 0){
                System.out.print(ball + " 볼");
            }
            System.out.println();
        }
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
        int[] userNum = new int[3];

        do{
            number = Integer.parseInt(sc.nextLine());
            userNum[0] = number/100;
            userNum[1] = (number%100)/10;
            userNum[2] = number%10;

        }while(!isValidNumber(userNum));

        return userNum;
    }

    /*
     * 사용자로부터 입력받은 숫자가 유효한지 여부를 반환하는 메서드
     * 세자리 숫자로만 이루어져야 하며 중복된 숫자는 없어야 한다
     */
    @Override
    public boolean isValidNumber(int[] userNum) {

        for(int i = 0 ; i < 3 ; i++ ){
            // 각 자릿수는 1~9 사이 값이어야 하고, 중복되어 사용된 숫자가 없어야 한다
            if(userNum[i] >= 10 || userNum[i] <= 0 || !isOverUse(userNum, i)){
                System.out.println("1~9 사이의 숫자를 중복없이 사용하여 세자릿수를 입력해주세요.");
                return false;
            }
        }

        return true;
    }

    /*
     * 중복되어 사용된 숫자가 있는지 검사하는 메서드
     */
    public boolean isOverUse(int[] userNum, int i){
        for(int prev = 0 ; prev < i ; prev++){
            if(userNum[i] == userNum[prev]){
                return false;
            }
        }
        return true;
    }

    /*
     * 프로그램이 생성한 숫자와 유저가 입력한 숫자를 비교하여
     * 결과를 만들어내는 함수
     */
    @Override
    public boolean judgeNumber(int[] userNum, int[] answer) {

        int strike = 0;
        int ball = 0;

        checkLoop:
        for(int u = 0 ; u < 3 ; u++){
            if(userNum[u] == answer[u]){
                strike++;
                continue checkLoop;
            }else{
                for(int a = 0 ; a < 3 ; a++){
                    if(userNum[u] == answer[a]){
                        ball++;
                        continue checkLoop;
                    }
                }
            }
        }

        if(strike == 3){
            showSuccessMsg();
            return true;
        }else{
            showResult(strike, ball);
            return false;
        }

    }

    /*
     * 성공 시 게임 재시작 여부를 묻는 메서드
     */
    @Override
    public int wantRestart() {

        int answer = 0;

        while(true){
            showRestartMsg();
            answer = Integer.parseInt(sc.nextLine());
            if(answer == 1 || answer == 2){
                break;
            }
        }
        return answer;
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
