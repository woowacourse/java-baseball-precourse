/*
 * @(#)BaseballGame.java        0.2 2019/03/25
 *
 *
 */

package baseballgame;

import java.util.Scanner;

/**
 * 기능 목록 4 - 전체적인 게임 시작 기능
 * 기능 목록 5 - 사용자의 3자리 수를 컴퓨터가 생성한 수와 비교 기능
 *
 * @version         0.2 2019년 3월 25일
 * @author          반선호
 */
public class BaseballGame {

    /** 게임 시작을 판단하기 위한 상수*/
    private static final String CONTINUE = "1";

    /** 게임 중지를 판단하기 위한 상수*/
    private static final String STOP = "2";

    /** 사용자의 시도횟수를 초기화하기 위한 상수*/
    private static final int RESET_NUMBER = 0;

    /** com 객체 선언, 새 게임을 시작할 때마다 인스턴스를 생성 한다.*/
    private Computer com;

    /** 사용자의 입력을 받기 위한 user 인스턴스 생성*/
    private User user = new User();

    /** 사용자의 시도 횟수 저장을 위한 변수*/
    private int cnt;

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

            resetComAndCnt();
            requestNumAndCheck();
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

    /**
     * 새 게임을 위해 초기화를 진행하는 메소드 입니다.
     * 새로운 숫자생성을 위해 com 인스턴스를 생성하고, 시도 횟수를 0으로 초기화 합니다.
     */
    private void resetComAndCnt(){
        com = new Computer();
        cnt = RESET_NUMBER;
        System.out.println(com.number);
    }

    /**
     * 사용자가 정답을 맞출 때까지 숫자 입력을 요청하고 시도 횟수를 증가 시키는 메소드입니다.
     */
    private void requestNumAndCheck(){
        while(true){
            user.requestNumber();
            cnt++;
            if(isCorrect()){
                break;
            }
            else{
                /*스트라이크 볼의 개수를 count할 메소드가 입력될 곳입니다.*/
            }
        }
    }

    /**
     * 사용자가 입력한 숫자가 컴퓨터의 숫자와 일치하는지 확인하는 메소드입니다.
     * @return 만약 일치하다면 true를 return 합니다.
     */
    private boolean isCorrect(){
        boolean status = false;
        if(user.number.equals(com.number)){
            System.out.println("정답입니다! " + cnt + "번 만에 성공 하셨습니다.");
            System.out.println();
            System.out.print("새로운 ");
            status = true;
        }
        return status;
    }
}
