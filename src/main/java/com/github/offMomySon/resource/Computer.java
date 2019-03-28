/*
 * Computer
 *
 * @version 1
 *
 * @date 2019-3-28
 *
 * Copyright (c) 2019 Jihun oh.
 * All rights reserved.
 */
package com.github.offMomySon.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @desc : Computer Class
 * 컴퓨터가 가져야 하는 랜덤한 수 3개를 생성하며,
 * 램덤한 수 3개를 List와 HashMap 을 이용하여 저장한다.
 * @pakage : com.github.offMomySon.resource
 */
public class Computer {
    private HashMap<Integer, Integer> numsMap;
    private List<Integer> numsList;

    public Computer() {
        numsMap = new HashMap<>();
        numsList = new ArrayList<>();
    }

    /**
     * @desc : 서로다른 1~9인 정수 3개를 만드는 함수
     * 이미 존재하는 수를 만들거나, 유효하지 않은 수이면 다시 만든다.
     */
    public void create_randnum() {
        while (numsMap.size() < 3) {
            int new_number = (int) (Math.random() * 10) + 1;

            if (is_keyValid(new_number) == false)
                continue;

            numsList.add(new_number);
            numsMap.put(new_number, new_number);
            System.out.print(new_number);
        }

    }

    /**
     * @param : 새로 만들어진 수
     * @desc : 새로 만들어진 수가 중복하지 않으며, 유효한 수인지 검사
     */
    private boolean is_keyValid(int new_number) {
        if (new_number >= 10 || numsMap.containsKey(new_number))
            return false;
        else
            return true;
    }

    /**
     * @desc : Computer가 랜덤으로 생성한 3가지 수를 List Class로 Return
     */
    public List<Integer> getNumsList() {
        return numsList;
    }

    /**
     * @return Computer가 랜덤으로 생성한 3가지 수를 HashMap Class로 Return
     */
    public HashMap<Integer, Integer> getNumsMap() {
        return numsMap;
    }
}
