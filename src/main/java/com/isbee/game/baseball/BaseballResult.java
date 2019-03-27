package com.isbee.game.baseball;

/**
 * 야구 게임 결과를 관리하는 클래스
 *
 * @author isbee
 * @version 1.0
 */
public class BaseballResult {

    private String result;

    public BaseballResult() {
        this.result = "";
    }

    /**
     * strike/ball 갯수에 따라 결과 String을 concate한다
     *
     * @return 객체 자신을 return하여 Builder 패턴처럼 this.printResult() 할 수 있도록 함.
     */
    public BaseballResult parseResult(int strikeNum, int ballNum) {
        if (strikeNum > 0) {
            result += strikeNum + " 스트라이크 ";
        }
        if (ballNum > 0) {
            result += ballNum + " 볼";
        }
        return this;
    }

    /** 결과 String 출력  */
    public void printResult() {
        if (!result.equals("")) {
            System.out.println(result);
        } else {
            System.out.println("낫싱");
        }
    }
}
