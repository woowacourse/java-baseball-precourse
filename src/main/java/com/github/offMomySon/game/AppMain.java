/*
 * AppMain
 *
 * @version 1
 *
 * @date 2019-3-28
 *
 * Copyright (c) 2019 Jihun oh.
 * All rights reserved.
 */
package com.github.offMomySon.game;

import com.github.offMomySon.game.baseball.BallType;
import com.github.offMomySon.resource.Computer;
import com.github.offMomySon.resource.User;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @desc : AppMain Class
 * @pakage : com.github.offMomySon.game
 */
public class AppMain {
    /**
     * @desc 어플리케이션의 시작, 종료  메인스트림
     * @desc 테스트
     */
    public static void main(String[] args) {

        System.out.println("Test");

        Game g = new Game();
        g.init();
        g.run();

    }
}
