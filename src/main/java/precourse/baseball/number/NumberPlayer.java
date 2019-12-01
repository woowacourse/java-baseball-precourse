/*
 * @(#)NumberPlayer.java 2019/12/1
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package precourse.baseball.number;

import precourse.baseball.Player;

import java.security.InvalidParameterException;

import java.util.Scanner;

/**
 * @version     1.00 2019년 12월 1일
 * @author      임근원
 */
public abstract class NumberPlayer implements Player {
    /* NumberPlayer는 숫자 야구 게임에 참여하는 게임 플레이어(타자, 투수 등)입니다. */

    protected Scanner scanner;

    protected NumberPlayer() {
        this.scanner = new Scanner(System.in);
    }
    protected NumberPlayer(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean wantToPlayAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Integer input = scanner.nextInt();
        if (!isValid(input)) {
            throw new InvalidParameterException("입력값이 옳바르지 않습니다.");
        }

        return input.equals(Will.WantToPlay.getValue());
    }
    private boolean isValid(Integer input) {
        return input.equals(1) || input.equals(2);
    }
}
