/*
 *  @(#)Main.java       1.00    2019/03/25
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 */

package baseball;

/**
 * 프로그램을 실행하기 위한 메인 클래스다.
 * Game class 객체를 생성하고, Game class의 run 메서드를 실행한다
 * @version        1.00     2019년   3월  25일
 * @author         사명기
 */
public class Main {
    public static void main(String[] args) {
        Game baseball=new Game();
        baseball.run();
    }
}
