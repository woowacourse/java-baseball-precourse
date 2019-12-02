/*
 * JavaBaseball 
 *
 * version: 1
 *
 *
 */

import java.util.Scanner;

public class BaseballGame {

    String player1;
    String player2;
    int strikeCnt;
    int ballCnt;

    public void setGame(){
        this.player1 = "";
        this.player2 = "";
        this.strikeCnt = 0;
        this.ballCnt = 0;

        GenerateNumber num = new GenerateNumber();

        while(true) {
            player1 = num.make();
            if(checkZeroNum(player1) && checkDupNum(player1)){ // 만들어진 수 검증
                break;
            }
        }
    }

    public void play(){
        boolean isUnipue = false;

        while(!isUnipue){
            inputNum();
            checkInput();
            judge();
        }
    }

    private boolean checkDupNum(String player){ // 숫자 중복 체크 메소드
        if((player.charAt(0) != player.charAt(1))
            && (player.charAt(1) != player.charAt(2))
            && (player.charAt(0) != player.charAt(2))){
                return true;
        }
        return false;
    }

    private String inputNum(){ //사용자에게 입력 받는 메소드
        while (true) {
            print("숫자를 입력해주세요 : ");
            Scanner sc = new Scanner(System.in);
            player2 = sc.nextLine();

            if(player2 == null){
                print("입력한 값이 없습니다. 다시 입력해주세요!");
            }
            else {
                return player2;
            }
        }
    }

    private boolean checkInput(){
        if(!checkNum()){
            print("숫자가 아닙니다. 다시 입력해주세요!");
            return false;
        }
        if(!checkNumCnt()){
            print("3자리 숫자가 아닙니다. 다시 입력해주세요!");
            return false;
        }
        if(!checkZeroNum(player2)){
            print("0이 숫자에 포함되어 있습니다. 다시 입력해주세요!");
            return false;
        }
        if(!checkDupNum(player2)){
            print("중복된 숫자가 있습니다. 다시 입력해주세요!");
            return false;
        }
        return true;
    }

    private boolean checkNum(){ //숫자로만 이뤄졌는지 검증하는 메소드
        if(Integer.parseInt(player2) > 0){
            return true;
        }
        else return false;
    }

    private boolean checkNumCnt(){ //3자리 수가 맞는지 검증하는 메소드
        if(player2.length() != 3){
            return false;
        }
        return true;
    }

    private boolean checkZeroNum(String player) { //0이 있는지 검증하는 메소드
        for (int i = 0; i < player.length(); i++) {
            if (player.charAt(i) == '0') {
                return false;
            }
        }
        return true;
    }

    private void judge(){ //스트라이크, 볼 판단하는 메소드
        int strikeIdx[] = new int[3];
        if(player1.equals(player2)){ //전부 다 스크라이크인 경우
            print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            end();
        }
        for(int i = 0; i < 3; i++){
            if(player1.charAt(i) == player2.charAt(i)){
                strikeCnt++;
                strikeIdx[i] = 1;
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(strikeIdx[i] == 1) continue;
                if(player1.charAt(i) == player2.charAt(j)){
                    ballCnt++;
                }
            }
        }

        if(strikeCnt == 0 && ballCnt == 0){
            print("낫싱");
        }
        else{
            print(strikeCnt + " 스트라이크 " + ballCnt + " 볼 ");
        }
    }

    private void end(){
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner sc = new Scanner(System.in);
        String signal  = sc.nextLine();

        if(signal.equals(1)){
            setGame();
            play();
        }
        else if(signal.equals(2)){
            return;
        }
        else {
            print("1 혹은 2를 입력하세요!");
            end();
        }
    }

    private void print(String s) {
        System.out.print(s);
    }
}
