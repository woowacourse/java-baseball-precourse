/*
 * BaseballMain.java               1.0.0   2019-12-03
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package com.precourse.baseball;

import java.io.IOException;

/**
 * 숫자야구게임을 진행하는 메인 클래스입니다.
 * main method를 실행합니다.
 *
 * @author HyungjuAn
 * @version 1.0.0
 * @date 2019-12-03
 */
public class BaseballMain {
    public static void main(String[] args) throws IOException {
        Player computer = new Player();
        Player user = new Player();

        Game.startGame(computer, user);
    }
}
