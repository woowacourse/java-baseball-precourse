package com.github.offMomySon.game;

import com.github.offMomySon.resource.Computer;
import com.github.offMomySon.resource.User;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @desc : AppMain Class
 * @pakage : com.github.offMomySon.game
 * @authon : 오지훈
 */

public class AppMain {
    /**
     * @desc 어플리케이션의 시작, 종료  메인스트림
     * @desc 테스트
     */
    public static void main(String[] args) {

        System.out.println("Test");
        User user = new User();
        user.inputNums();

        HashMap<Integer, Integer> computerNum = user.getNumsMap();
        Set<Integer> keys = computerNum.keySet();

        List<Integer> list = user.getNumsList();

        for (Integer key : keys) {
            System.out.println(computerNum.get(key));
        }
        for (Integer n : list) {
            System.out.println(n);
        }
    }
}
