package com.github.offMomySon.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @desc : Computer Class
 * 랜덤한 수 3개를 생성하며,
 * List와 HashMap 을 이용하여 저장한다.
 *
 * @pakage : com.github.offMomySon.resource
 * @authon : 오지훈
 */

public class Computer {
    private HashMap<Integer, Integer> numsMap;
    private List<Integer> numsList;

    public Computer(){
        numsMap = new HashMap<>();
        numsList = new ArrayList<>();
        create_randnum();
    }

    /**
     * @desc : 서로다른 1~9인 정수 3개를 만드는 함수
     */
    public void create_randnum() {
        while(numsMap.size()< 3){
            int new_number = (int)(Math.random()*10) +1;

            numsMap.put(new_number, new_number);
        }

        for( Integer num : numsMap.keySet()){
            numsList.add(num);
        }
    }

    /**
     * 인스턴스 변수 numsList의 getter
     * @return :
     */
    public List<Integer> getNumsList(){
        return numsList;
    }

    /**
     * 인스턴스 변수 numsMap의 getter
     * @return :
     */
    public HashMap<Integer, Integer> getNumsMap(){
        return numsMap;
    }
}
