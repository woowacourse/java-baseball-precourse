/*
 * @(#)Repeater.java
 * 
 * version : 1.0
 * 
 * 2019.12.01
 */

package mypackage.minuyim.baseball.util;

import java.util.Scanner;

/**
 * Repeater : 게임의 재시작 여부를 사용자에게 묻는 클래스
 * 
 * @version 1.00 2019/12/01
 * @author 임민우
 */
public class Repeater {

    public static int askAgain() {
        Scanner sc = new Scanner(System.in);
        int num;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while (true) {
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("숫자를 입력하세요.");
            }
            num = sc.nextInt();
            if (num != 1 && num != 2) {
                System.out.println("올바른 숫자를 입력하세요.");
            } else {
                break;
            }
        }
        return num;
    }
}