/*
* Class Name: main.java
* Version: 0.1
* Date: 2019.11.28
* Copyright(c) 2019 Sujin Cha(MIR013)
* All rights reserved.
*
* This software is made for precourse of woowacourse.
*/

//package

//import
import java.util.Scanner;

/**
 * 클래스 Main의 역할
 * 전체 게임의 흐름을 담당한다.
 * 객체들을 생성하고, 값을 입력받고, 게임시작흐름을 관리한다.
 * 어떻게보면, 사용자와 유사하다.
 */
public class Main {

    private static final int BASEBALL_SIZE = 3;

    public static void main(String[] agrs)
    {
        System.out.println("hello! Wellcome to baseball game");
        //변수 생성
        Scanner scan = new Scanner(System.in);  // 입력용 스캐너
        int isGoing;                // 게임 진행 여부

        //게임 진행
        do{
            playBaseballGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isGoing = scan.nextInt();
        }while(isGoing == 1);

    }

    /** 1번의 게임을 돌린다. */
    private static void playBaseballGame()
    {
        //변수 생성
        Computer computer = new Computer();     // 컴퓨터 객체 생성
        String value = new String();         // 입력값 저장용 변수
        Scanner scan = new Scanner(System.in);  // 입력용 스캐너

        //게임 시작
        do{
            do{
                value = generateValue();
            }while(value == null);
        }while(computer.checkBaseball(value));

        //게임 종료
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        return;
    }

    /** 값을 생성해온다. */
    private static String generateValue()
    {
       return null;
    }



}
