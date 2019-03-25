package com.woowa.baseball;

import org.junit.Test;

public class UniqueNumberTest {

    @Test
    public void compareAnswerTest(){
        int[] answerNum = {3, 5, 8};
        int[] customNum = {3, 8, 5};
        UniqueNumber answer = new UniqueNumber(answerNum);

        int[] hint = answer.compareTo(customNum);
        System.out.println("Strike : " + hint[0]);
        System.out.println("Ball : " + hint[1]);
    }
}
