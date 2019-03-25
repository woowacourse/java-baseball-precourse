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