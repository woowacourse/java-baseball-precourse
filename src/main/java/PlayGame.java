/*
 * 클래스 이름: PlayGame.java
 * 버전 정보: 1.0.0
 * 날짜: 2019/03/27
 * Copyright 2018 Inkwon Lee
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * 게임 플레이를 실적적으로 구동 하는 부분
 * 게임 시스템에 대한 담당을 하는 클래스
 * 게임에 나갈 때 잘못 누를경우 예외를 처리함.
 */
public class PlayGame {

    /** 게임을 시작하는 함수 do while문을 사용해
     *  게임을 플레이어가 끝내는 신호를 보낼때 까지 계속 무한 반복 실행*/
    public void startGame() throws IOException {

        HashMap hashMap;
        int gameResult;
        String[] playerNum;

        System.out.println("숫자 야구게임을 시작합니다.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
           hashMap = Number.getInstance().comNum(); // 컴퓨터 3자리 난수 생성
            do {
                playerNum = Number.getInstance().playerNum(br); // 플레이어 입력 부분
                gameResult = Feature.getInstance().checkNum(hashMap, playerNum); // 점수 나오는 값
            } while (gameResult != 3); // gameResult 가 strike 의 개수, 값이 3이면 게임 종료.
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        } while (isExit(br)); // isExit()가 false 이면 종료

    }

    /** 새게임, 종료 물어보는 함수 */
    private boolean isExit(BufferedReader br) throws IOException{
        while(true){
            String exitNum = br.readLine();

            if (exitNum.equals("1")) {
                return true;
            } else if (exitNum.equals("2")) {
                return false;
            } else { // 다른 문자가 올경우 예외처리
                System.out.println(ErrorMessage.OTHER_NUMBER_ERROR.getErrorMessage());
            }

        }
    }

}
