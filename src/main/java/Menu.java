/*
 *@(#)Menu.java           1.1 2019/03/27
 *Copyright (c) 2019 Hyogeon Kim.
 *Number Baseball Game, Java, Mungyeong, KOREA
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 야구게임 메뉴(게임실행/게임종료)에 대한 출력/선택의 역할을 수행하는 클래스
 * @version               1.1 2019년 03월 26일
 * @author                김효건
 */
public class Menu {
        /*메뉴 출력,선택 구현*/

        /**게임 시작,종료에 대한 메뉴를 출력*/
        public static void printMenu() {
                System.out.print(" << 게임 시작(1)  ");
                System.out.println("게임 종료(2) >>");
        }

        /**게임 시작,종료에 대한 메뉴를 입력*/
        public static int selectMenu() {
                int select;

                Scanner scan = new Scanner(System.in);
                try {
                        select = scan.nextInt();
                        if (select != 1 && select != 2) {
                                throw new selectMenuInputException();
                        }
                }catch(selectMenuInputException e){
                        System.err.println("1또는 2를 입력 해주세요.");
                        return -1;
                }catch(InputMismatchException e){
                        System.err.println("1또는 2를 입력 해주세요.");
                        return -1;
                }
                return select;
        }
        /**
         * @return int 시작(1) 종료(2)에 대해 입력받은 값을 반환
         */

        /**메뉴를 입력 받을 때 예외처리 - 게임시작(1) 게임종료(2) 이 외의 값이 입력 된 경우*/
        public static class selectMenuInputException extends RuntimeException{
        }
}