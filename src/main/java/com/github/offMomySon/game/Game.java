/*
 * Game
 *
 * @version 1.1
 *
 * @date 2019-3-28
 *
 * Copyright (c) 2019 Jihun oh.
 * All rights reserved.
 */

package com.github.offMomySon.game;

import com.github.offMomySon.resource.Computer;
import com.github.offMomySon.resource.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @desc : Game Class
 * 야구게임 전체의 흐름을 주관하는 Class 이다.
 * Computer Class 를 이용하여 Random 한 수를 가져오고, User Class 를 통해 3자리 수를 입력받는다.
 * Random 수와 사용자 입력값을 비교하여 BallType 을 통해 결과값을 받아온다.
 * User Class를 통해 게임 진행여부를 묻고 받아온다.
 * @pakage : com.github.offMomySon.game
 */
public class Game {
    private Computer computer;
    private User user;

    public Game() {
        this.computer = new Computer();
        this.user = new User();
    }

    /**
     * @desc : 게임 시작전, 컴퓨터의 Random 숫자를 셋팅한다.
     */
    public void init() {
        computer.create_randnum();
    }


    /**
     * @desc : 게임의 Sequence [ 입력요청, 입력, 힌트출력, 게임종료 선택 ] 를 순서대로 수행한다.
     */
    public void run() {
        while (true) {
            request_Input();
        }
    }

    /**
     * @desc : 사용자로 부터 입력을 요청,
     * 잘못된 수 입력시, 재입력 요청
     */
    private void request_Input() {
        System.out.print("숫자를 입력해주세요 : ");
        user.inputNums();
    }
}
