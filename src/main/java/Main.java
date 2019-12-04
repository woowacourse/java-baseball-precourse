/*
 * Batter.java
 *
 * 2019/12/3
 */

import java.util.*;

/**
 * Precourse 1주차
 * Main.java
 * Purpose : 숫자 야구게임에서 사용자와 컴퓨터의 인스턴스를 생성하고 게임을 수행하는 클래스
 *
 *   @version         1.00 2019/12/3
 *   @author          김태헌
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args are not used
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Batter computer;
        Pitcher user;
        int pitch = 0;                                      //사용자로부터 입력받는 pitching 3자리 정수
        int continueGame = 0;                               //사용자로부터 입력받는 게임을 계속 할지에 대한 1자리 정수

        while(true) {

            /* 게임은 사용자가 게임종료 후 2를 입력해야만 종료할 수 있으므로 무한Loop 를 base 로 하여 진행된다. */
            computer = new Batter();                    //Batter 인스턴스 생성
            System.out.print("숫자를 입력해 주세요 : ");
            pitch = s.nextInt();                        //사용자로부터 3자리 정수를 입력받는다.
            user = new Pitcher(pitch);                  //Pitcher 인스턴스 생성

            while (computer.game(user) != true) {       //Batter 클래스의 game 메소드가 true 를 반환할 때 까지 게임 진행
                System.out.print("숫자를 입력해 주세요 : ");
                pitch = s.nextInt();
                user = new Pitcher(pitch);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로시작하려면 1, 종료하려면 2를 입력하세요");
            continueGame = s.nextInt();

            if (continueGame == 1) {
                continue;           //사용자가 게임을 계속하는 경우 while loop 계속 진행
            } else return;          //사용자가 게임을 그만하는 경우 프로그램 종료
        }


    }
}
