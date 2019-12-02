package com.woowacourse.baseballgame;

import com.woowacourse.baseballgame.system.BaseballGameSystem;

public class BaseballGameApplication {
    public static void main(String[] args) {
        BaseballGameSystem baseballGameSystem = new BaseballGameSystem();
        baseballGameSystem.startGame();
    }
}
