/*
 *  @(#)Player.java       1.00    2019/03/23
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 */

package baseball;


import java.util.Scanner;

/**
 * Player interface
 * 이 인터페이스는 각 클래스에서 수를 만드는 메서드,
 * 그 수를 가져오는 메서드,
 * 프로그램을 계속 실행할 지 판단하는 메서드가 있다.
 *
 * @version        1.00     2019년   3월  23일
 * @author         사명기
 */

public interface Player {
    Scanner sc=new Scanner(System.in);

    void makeNewNumber();

    int[] getNumbers();

    boolean isContinue();
}