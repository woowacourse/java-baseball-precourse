/*
 * Game
 *
 * @version 1.2
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @desc : Game Class
 * 야구게임 전체의 흐름을 주관하는 Class 이다.
 * Computer Class 를 이용하여 Random 한 수를 가져오고, User Class 를 통해 3자릿수를 입력받는다.
 * Random 수와 사용자 입력값을 비교하여 BallType 을 통해 결과 값을 받아온다.
 * User Class 를 통해 게임 진행 여부를 묻고 받아온다.
 * @pakage : com.github.offMomySon.game
 */
public class Game {
    private Computer computer;
    private User user;

    public Game(User user) {
        this.user = user;
        this.computer = new Computer();
    }

    /**
     * @desc : 게임 시작 전, 이전에 셋팅 되었던 Computer Class 의 3개의 수를 초기화한다.
     * Computer Class 의 3개의 Random 숫자를 셋팅한다.
     */
    public void init() {
        computer.init();
        computer.create_randnum();
    }

    /**
     * @desc : 게임의 Sequence 를 순서대로 실행한다.
     */
    public void run() {
        List<Integer> score;

        while (true) {
            request_Input();
            score = count_Score();
            print_hint(score);

            if (score.get(0) == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    /**
     * @param score Strike, Ball count 가 담긴 List Class를 파라미터로 받는다.
     * @desc : Strike, Ball count 의 결과를 문자열로 표현한다.
     */
    private void print_hint(List<Integer> score) {
        int strike_count = score.get(0);
        int ball_count = score.get(1);

        System.out.println(new BallType(strike_count, ball_count));
    }

    /**
     * @desc : 사용자로부터 입력을 요청한다. 잘못된 수 입력 시, 재입력 요청한다.
     */
    private void request_Input() {
        System.out.print("숫자를 입력해주세요 : ");
        user.inputNums();
    }

    /**
     * @return : Strike, Ball 의 개수를 List Class 를 통해 반환한다.
     * @desc : 컴퓨터의 수와, 사용자의 수를 비교하여 Strike, Ball 개수를 반환하는 함수.
     */
    private List<Integer> count_Score() {
        HashMap<Integer, Integer> com_NumMap = computer.getNumsMap();
        List<Integer> com_NumList = computer.getNumsList();
        List<Integer> user_NumList = user.getNumsList();
        List<Integer> score = new ArrayList<>();
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < user_NumList.size(); i++)       // 사용자에게 입력받은 숫자 순서대로 검사한다.
        {
            Integer computer_num = com_NumList.get(i);
            Integer user_num = user_NumList.get(i);

            if (computer_num.equals(user_num))              // 같은 자리에 같은 수가 있으면 strike count 1증가 시킨다.
                strike += 1;
            else if (com_NumMap.containsKey(user_num))      // 다른 자리에 같은 수가 있으면 ball count 1증가 시킨다.
                ball += 1;
        }
        score.add(strike);
        score.add(ball);

        return score;
    }
}
