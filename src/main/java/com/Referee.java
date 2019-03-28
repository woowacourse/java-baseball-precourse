/*
* Referee.java
*
* version 1.0        2019.03.27
*
* JDK 1.8
*
* Copyright (c) 2019 Jong Min Lee.
* All right reserved.
*/

package com;

/*
* 심판 클래스로 사용자와 컴퓨터가 가져온 숫자를 판단하는 클래스 입니다.
* 결과 가져오기, 판단하기, 스트라이크 갯수 카운팅 기능 갖고 있습니다.
*
* @version 1.00 2018.3.27
* @author 이종민
*/

public class Referee {
    private String comNumber;
    private int ball;
    private int strike;

    /* 심판이 컴퓨터의 숫자와 사용자의 숫자 비교판단
     * @return strike 갯수
     */
    public int judgeTheStrike(String comNumber, String userNumber) {
        this.comNumber = comNumber;
        int userNumLen = userNumber.length();

        for (int i = 0; i < userNumLen; i++) {
            getStrikeZon(userNumber.charAt(i), i);
        }

        return getStrike();
    }

}
