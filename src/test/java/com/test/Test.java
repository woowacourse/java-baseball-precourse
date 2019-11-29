package com.test;

import com.jenny.baseball.Baseball;
import com.jenny.baseball.Gamable;

public class Test {

    public static void createNumberTest(){

        Gamable test = new Baseball();
        int[] num = test.createNumber();

        for(int i = 0 ; i < 3 ; i++){
            System.out.print(num[i]);
        }System.out.println();
    }

    public static void main(String[] args) {

        createNumberTest();

    }
}
