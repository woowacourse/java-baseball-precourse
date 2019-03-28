/*
 * AppMain
 *
 * @version 1.1
 *
 * @date 2019-3-28
 *
 * Copyright (c) 2019 Jihun oh.
 * All rights reserved.
 */
package com.github.offMomySon.game;

import com.github.offMomySon.resource.User;

/**
 * @desc : AppMain Class
 * @pakage : com.github.offMomySon.game
 */
public class AppMain {
    /**
     * @desc 어플리케이션을 통해, 게임의 흐름을 제어하고, 재시작 여부를 유저에게서 받아오는 메인 메소드.
     */
    public static void main(String[] args) {
        User user = new User();
        Game g = new Game(user);

        while (true) {
            g.init();
            g.run();
            if (!user.isContinue())
                break;
        }
    }
}
