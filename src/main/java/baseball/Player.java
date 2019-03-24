/*
 *  @(#)Player.java       1.00    2019/03/23
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 */

package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @version        1.00     2019년   3월  23일
 * @author         사명기
 */

public interface Player {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public void makeNewNumber() throws IOException;

}