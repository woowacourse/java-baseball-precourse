/*
 *  클래스 이름 : Result.java
 *
 *  버전 정보 :
 *
 *  날짜 : 2019-03-27
 *
 *  저작권 : 이예지
 */

package com.woowacourse.baseball;

/**
 * 6. 비교 결과를 저장하는 클래스
 */
public class Result {

    private int strikeCount;

    private int ballCount;

    public Result(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    //비교 결과를 출력하는 메소드.
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        if (strikeCount>0) {
            sb.append(strikeCount+" 스트라이크 ");
        }

        if (strikeCount==3) {
            sb.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        if (ballCount>0) {
            sb.append(ballCount+" 볼 ");
        }

        if (strikeCount==0 && ballCount == 0) {
            sb.append("낫싱");
        }

        return sb.toString();
    }
}