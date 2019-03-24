package com.woowa.baseball;

import org.junit.Test;

public class UniqueNumberMakerTest {

    /**
     * UniqueNumberMaker 객체가 중복되지 않은 UniqueNumber 인스턴스를 만드는지
     * 확인하는 테스트
     */
    @Test
    public void UniqueNumberMakeTest() {
        UniqueNumberMaker uniqueNumberMaker = new UniqueNumberMaker();
        UniqueNumber uniqueNumber;

        for (int i = 0; i < 10; i++) {
            uniqueNumber = uniqueNumberMaker.create();
            int[] testArr = uniqueNumber.getAnswerNumber();

            System.out.println(testArr[0] + " " + testArr[1] + " " + testArr[2]);
        }
    }
}
