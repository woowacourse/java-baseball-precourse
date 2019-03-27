/*
 *@(#)Menu.java           1.1 2019/03/26
 *Copyright (c) 2019 Hyogeon Kim.
 *Number Baseball Game, Java, Mungyeong, KOREA
 */

import java.util.Scanner;

/*
 * 야구게임 메뉴(게임실행/게임종료)에 대한 출력/선택의 역할을 수행하는 클래스
 * @version               1.1 2019년 03월 26일
 * @author                김효건
 */
public class Menu {
    /*메뉴 출력,선택 구현*/

    /*게임 시작,종료에 대한 메뉴를 출력*/
    public static void printMenu(){
        System.out.print(" << 게임 시작(1)  ");
        System.out.println("게임 종료(2) >>");
    }

    /*게임 시작,종료에 대한 메뉴를 입력*/
    public static int selectMenu(){
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
    /*
     * @return int 시작(1) 종료(2)에 대해 입력받은 값을 반환
     */
}