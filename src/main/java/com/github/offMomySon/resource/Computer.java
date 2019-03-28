/*
 * Computer Class
 *
 * @version 1.1
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
 * @desc Computer Class
 * 컴퓨터가 가져야 하는 랜덤 한 수 3개를 생성하며,
 * 램덤 한 수 3개를 List 와 HashMap 을 이용하여 저장한다.
 * @pakage com.github.offMomySon.resource
 */
public class Computer {
    private HashMap<Integer, Integer> numsMap;
    private List<Integer> numsList;

    public Computer() {
        numsMap = new HashMap<>();
        numsList = new ArrayList<>();
    }

    /**
     * @desc create_randnum() 에서 만들어진 3개의 수를 초기화하는 메서드.
     */
    public void init() {
        numsMap.clear();
        numsList.clear();
    }

    /**
     * @desc 서로 다른 1~9인 정수 3개를 만드는 메서드.
     * 이미 존재하는 수를 만들거나, 유효하지 않은 수이면 다시 만든다.
     */
    public void create_randnum() {
        while (numsMap.size() < 3) {
            int new_number = (int) (Math.random() * 10) + 1;

            /*유효하지 않은 수이면 추가하지 않는다.*/
            if (is_keyValid(new_number) == false)
                continue;

            /*유효한 수를 추가*/
            numsList.add(new_number);
            numsMap.put(new_number, new_number);
        }
    }

    /**
     * @param new_number random() 메서드를 통해 새롭게 만들어진 수.
     * @return 유효한 수이면 true 를 리턴.
     */
    private boolean is_keyValid(int new_number) {
        if (new_number >= 10 || numsMap.containsKey(new_number))
            return false;
        else
            return true;
    }

    /**
     * @return Computer Class 가 랜덤으로 생성한 3가지 수를 List 로 리턴.
     */
    public List<Integer> getNumsList() {
        return numsList;
    }

    /**
     * @return Computer Class 가 랜덤으로 생성한 3가지 수를 HashMap 으로 리턴
     */
    public HashMap<Integer, Integer> getNumsMap() {
        return numsMap;
    }
}
