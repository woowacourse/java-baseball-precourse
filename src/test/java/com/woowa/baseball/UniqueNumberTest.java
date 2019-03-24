package com.woowa.baseball;

import org.junit.Test;

public class UniqueNumberTest {

    @Test
    public void compareAnswerTest(){
        int[] answerNum = {3, 5, 8};
        int[] customNum = {4, 9, 2};
        UniqueNumber answer = new UniqueNumber(answerNum);

        int[] hint = answer.compareAnswer(customNum);
        System.out.println("Strike : " + hint[0]);
        System.out.println("Ball : " + hint[1]);
    }
}
