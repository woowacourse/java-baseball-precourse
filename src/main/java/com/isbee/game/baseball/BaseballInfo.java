package com.isbee.game.baseball;

/**
 * 야구 게임 정보를 저장하는 POJO Singleton
 *
 * @author isbee
 * @version 1.0
 */
public enum BaseballInfo {

    INSTANCE;

    private int comNum;
    private int userNum;
    private int digitNum;

    BaseballInfo() {
        digitNum = 3;
    }

    public int getComNum() {
        return comNum;
    }

    public void setComNum(int comNum) {
        this.comNum = comNum;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public int getDigitNum() {
        return digitNum;
    }

    public void setDigitNum(int digitNum) {
        this.digitNum = digitNum;
    }
}