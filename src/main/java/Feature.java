/*
 * 클래스 이름: Feature.java
 * 버전 정보: 1.0.0
 * 날짜: 2019/03/27
 * Copyright 2018 Inkwon Lee
 */

import java.util.HashMap;

/*
 * 야구게임의 기능들을 모아둔 자바클래스
 * 컴퓨터 숫자와 플레이어 숫자를 비교하는 checkNum() 함수 및 점수를 출력하는 함수 구현
 */
public class Feature {

    /** 클래스 안에 클래스 holder를 두는 Singleton */
    private Feature(){ }
    private static class Featureholder{ public static final Feature INSTANCE = new Feature();}
    public static Feature getInstance(){ return Feature.Featureholder.INSTANCE; }

    /** 플레이어와 컴퓨터의 점수를 내기위한 체크 함수
     * 컴퓨터의 숫자에서 플레이어 숫자가 없을경우 nothing + 1
     * 컴퓨터의 숫자와 플레이어 숫자가 있는데 위치가 서로 다를경우 ball + 1
     * 컴퓨터의 숫자와 플레이어 숫자가 있고 위치도 같을경우 strike + 1 */
    public int checkNum(HashMap hashMap, String[] playerNum){
        int strike = 0, ball = 0, nothing=0;

        // 플레이어 숫자 첫번째가 0일경우 에러 -1로 리턴
        if(playerNum[0].equals("0")){
            return -1;
        }

        // 컴퓨터 숫자와 플레이어 숫자를 비교해주는 부분
        for(int i = 0 ; i < playerNum.length ; i++){
            if(!hashMap.containsValue(Integer.parseInt(playerNum[i]))){
                nothing++;
            } else if((int)hashMap.get(i) == Integer.parseInt(playerNum[i])){
                strike++;
            } else{
                ball++;
            }
        }

        // 점수 출력해주는 함수
        printScore(strike, ball, nothing);
        return strike;
    }

    /** 점수 출력문 */
    private void printScore(int strike, int ball, int nothing){
        if(nothing == 3){  // 아예 없는경우
            System.out.println("낫싱");
        } else if(strike == 3){ // 정답이 맞은 경우
            System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
        } else if(ball == 0 || strike == 0){ // ball 하고 strike 가 0인경우 2가지로 나뉨
            if(ball == 0){ // strike 부분만 출력
                System.out.println(strike + " 스트라이크");
            }
            if(strike == 0) { // ball 부분만 출력
                System.out.println(ball + " 볼");
            }
        } else{ // strike 랑 ball 둘다 있는 경우
            System.out.println(strike + " 스트라이크, " + ball + " 볼");
        }
    }
}
