/*
 * @(#)Application.java 2019/12/1
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

import precourse.baseball.*;
import precourse.baseball.number.NumberBaseballFactory;
import precourse.baseball.number.NumberHitter;
import precourse.baseball.number.NumberPitcher;
import precourse.baseball.number.NumberReferee;

import java.util.Scanner;

/**
 * @version     1.00 2019년 12월 1일
 * @author      임근원
 */
public class Application {

    /** 전체 프로그램을 구동하는 함수입니다. */
    public static void main(String[] args) {
        Baseball baseball = setupBaseball();
        baseball.play();
    }

    /** 전체 프로그램을 작동시키기 위해 프로그램을 준비시키는 함수입니다. */
    private static Baseball setupBaseball() {
        Hitter hitter = new NumberHitter();
        Scanner scanner = new Scanner(System.in);
        Pitcher pitcher = new NumberPitcher(scanner);
        Referee referee = new NumberReferee();
        BaseballFactory baseballFactory = new NumberBaseballFactory();
        return baseballFactory.create(hitter, pitcher, referee);
    }
}
