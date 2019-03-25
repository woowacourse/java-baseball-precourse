/*
 * @(#)BaseballGame.java        0.1 2019/03/25
 *
 *
 */

package baseballgame;

import java.util.Scanner;

/**
 * 기능 목록 4 - 전체적인 게임 시작 기능
 *
 * @version         0.1 2019년 3월 25일
 * @author          반선호
 */
public class BaseballGame {

    /** 게임 시작을 판단하기 위한 상수*/
    private static final String CONTINUE = "1";

    /** 게임 중지를 판단하기 위한 상수*/
    private static final String STOP = "2";

    /**
     * 게임 시작 메소드 입니다.
     * 해당 메소드에서 사용자의 입력을 판단하여 게임을 진행할지 그만할지 여부를 결정합니다.
     *
     */
    public void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            if(isStop()){

                /* 해당 조건을 만족한다면 2를 입력한 경우이기 때문에 게임을 종료합니다.*/
                System.out.println("숫자 야구 게임을 종료합니다.");
                break;
            }

            /*이 곳에 게임 실행을 위한 메소드가 삽입 될 예정입니다.*/
        }
    }

    /**
     * 사용자의 입력을 받는 메소드 입니다.
     * 1,2 이외의 입력은 모두 재요청합니다.
     * @return 만약 1을 입력하였다면 false, 2를 입력하였다면 true를 return합니다.
     */
    private boolean isStop(){
        Scanner sc = new Scanner(System.in);
        String input;

        while(true){
            System.out.println("게임을 시작하시려면 1, 종료하시려면 2를 입력해주세요.");
            input = sc.next();

            if(input.equals(CONTINUE) || input.equals(STOP)){
                break;
            }
            else {
                System.out.println("[ERROR]입력이 잘못 되었습니다. 다시 입력해주세요.");
            }

        }

        return input.equals(STOP);
    }
}
