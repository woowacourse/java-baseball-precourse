/*
 * @(#)NumberPitcher.java 2019/12/1
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

package precourse.baseball.number;

import precourse.baseball.number.errors.InvalidInputException;
import precourse.baseball.Pitcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @version     1.00 2019년 12월 1일
 * @author      임근원
 */
public class NumberPitcher extends NumberPlayer implements Pitcher {
    /* NumberPitcher는 숫자 야구 게임에 참여하는 투수입니다. */

    public NumberPitcher(Scanner scanner) {
        super(scanner);
    }

    @Override
    public List<Integer> pitch() {
        System.out.print("숫자를 입력해주세요 : ");;
        String input = scanner.next();
        if (!isValid(input)) {
            throw new InvalidInputException("입력값이 옳바르지 않습니다.");
        }

        return translateToBalls(input);
    }
    private boolean isValid(String input) {
        if (input.length() != NumberBaseballConfig.ROUND) {
            return false;
        }

        for (char syllable: input.toCharArray()) {
            if (!Character.isDigit(syllable)) {
                return false;
            }
        }

        return true;
    }
    private List<Integer> translateToBalls(String input) {
        List<Integer> balls = new ArrayList<>();
        for (char syllable: input.toCharArray()) {
            int ball = Character.getNumericValue(syllable);
            balls.add(ball);
        }
        return balls;
    }
}
