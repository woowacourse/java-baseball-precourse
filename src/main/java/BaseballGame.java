/*
 * class: BaseballGame
 *
 * version: 1.0
 *
 * date: 2019.11.29
 *
 * 이 프로그램의 저작권은 정은석에게 있습니다.
 * Copyright 2019.11.29
 */

import com.eunseok.baseballgame.Baseball;
import java.util.Scanner;

/**
 * 숫자 야구 게임을 실행하기 위한 BaseballGame.
 * 게임을 생성하기 위해 Baseball 클래스를 생성하여 게임을 실행.
 * exit 를 입력받아 1이면 restart 2이면 exit 를 해서 게임을 종료.
 *
 * @version 1.0 2019년 11월 29일
 * @author 정 은 석
 */
public class BaseballGame {
    public static void main(String[] args) {
        /**game 재시작을 위한 exit변수*/
        int exit = 0;
        /**게임을 생성하기 위해 class 객체생성 */
        Baseball game = new Baseball();
        /**exit input을 받기위해 Scanner객체 생성*/
        Scanner sc = new Scanner(System.in);

        /**
         * 게임을 여러번 실행하기 위한 반복문
         * exit조건에 따라 탈출
         */
        while(true) {
            game.start();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            exit = sc.nextInt();
            if (exit == 2) {
                break;
            }
        }
    }
}