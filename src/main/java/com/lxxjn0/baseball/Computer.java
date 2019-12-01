/*
 * @(#)Computer.java        0.1 2019/12/01
 *
 * Copyright (c) 2019 lxxjn0.
 */
package com.lxxjn0.baseball;

import java.util.ArrayList;
import java.util.Random;

/**
 * 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 생성하는 클래스.
 *
 * @version         0.1 2019/12/01
 * @author          Junyoung Lee (lxxjn0)
 */
public class Computer {
    /** 생성해야 하는 수의 길이를 저장한 상수 */
    private static final int NUM_LEN = 3;
    /** 각 자리에 생성될 숫자 범위의 상한 상수 */
    private static final int MAX_NUM = 9;
    /** 각 자리에 생성될 숫자 범위의 하한 상수 */
    private static final int MIN_NUM = 1;
    /** 생성하는 숫자를 저장할 ArrayList */
    private ArrayList<Integer> numList;

    /**
     * Computer 클래스의 생성자.
     * 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 생성.
     */
    public Computer() {
        int tmp;
        numList = new ArrayList<Integer>();

        while(numList.size() < NUM_LEN) {
            tmp = new Random().nextInt(MAX_NUM) + MIN_NUM;
            /* 이전에 생성된 수와 중복되지 않을 경우 numList에 추가 */
            if(!numList.contains(tmp)) {
                numList.add(tmp);
            }
        }
    }

    /**
     * numList getter
     * @return      numList : 조건에 맞게 생성된 3자리 수를 반환
     */
    public ArrayList<Integer> getNumList() {
        return numList;
    }
}
