/*
 *@(#)Game.java           1.0 2019/03/26
 *Copyright (c) 2019 Hyogeon Kim.
 *Number Baseball Game, Java, Mungyeong, KOREA
 */

import java.util.Random;

/*
 * 야구게임에 관련 된 클래스
 * @version               1.0 2019년 03월 26일
 * @author                김효건
 */
public class Game {
    /* 게임시작 / 게임종료
     * 게임화면 출력 / 세자리 숫자 생성
     * 세자리 숫자 입력 / 세자리 숫자 검사
     * 정답 화면 출력
     * 메소드 구현
     *  */

    /*게임시작 시 랜덤으로 지정 될 세자리 숫자*/
    private Number number;

    /*Game 클래스 생성자
     * 메뉴 출력 및 에러 출력
     * 종료 선택 시까지 반복
     * */
    Game(){
        while(true) {
            Menu.printMenu();

            /*선택 번호를 저장할 변수*/
            int select = Menu.selectMenu();
            if (select == 1)
                startGame();
            else if (select == 2)
                exitGame();
            else
                System.out.println("잘못 입력 하셨습니다.");
        }
    }

    /**/
    public void startGame(){

    }

    /*게임 종료(프로그램 종료 함수)*/
    public void exitGame(){
        System.exit(0);
    }

    /**/
    public void printGame(){

    }

}
