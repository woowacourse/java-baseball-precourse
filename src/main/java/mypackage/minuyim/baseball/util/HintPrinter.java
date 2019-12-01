/*
 * @(#)HintPrinter.java
 * 
 * version : 1.0
 * 
 * 2019.12.01
 */

package mypackage.minuyim.baseball.util;

/**
 * HintPrinter : 만들어진 힌트를 적절한 형태로 출력하는 클래스
 * 
 * @version 1.00 2019/12/01
 * @author 임민우
 */
public class HintPrinter {
    public static void printHint(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }
    }
}
