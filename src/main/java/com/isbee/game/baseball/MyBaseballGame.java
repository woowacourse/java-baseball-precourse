package com.isbee.game.baseball;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


/**
 * 야구 게임을 진행하는 BaseballGame 구현 클래스
 * Single thread를 기준으로 작성하여 ThreadLocalRandom을 사용했다 (thread-safe 하지 않다)
 *
 * @author isbee
 * @version 1.0
 */
public class MyBaseballGame implements BaseballGame {

    private BaseballInfo baseballInfo;

    public MyBaseballGame() {
        baseballInfo = BaseballInfo.INSTANCE;
    }

    /**
     * 1~9 사이의 중복없는 난수로 이루어진 수를 생성하여 리턴
     *
     * @return 플레이어가 맞춰야 할 난수
     */
    @Override
    public int generateRandomNum() {
        boolean check[] = new boolean[10];
        Arrays.fill(check, false);      // check 객체 생성 시점에 이미 각 요소가 0으로 초기화되면서 false가 되지만, 코드 가독성을 위해 fill 사용
        int random = 0;
        int digit = getUpperBound();

        while (digit > 0) {
            int r = getNonDuplicateRan(check);
            random += r * digit;
            digit /= 10;
        }
        return random;
    }

    /**
     * 야구 게임 자리수에 맞는 숫자 생성
     *
     * @return 생성한 숫자
     */
    private int getUpperBound() {
        int digit = baseballInfo.getDigitNum();
        int bound = 1;

        while (digit > 1) {
            bound *= 10;
            digit--;
        }
        return bound;
    }

    /**
     * 1~9 까지의 중복없는 난수 생성를 생성하여, 사용자가 맞춰야 할 수를 구성하는데 사용한다.
     *
     * @param check 현재까지 생성된 난수를 기록한 배열
     * @return 중복없는 난수
     * */
    private int getNonDuplicateRan(boolean check[]) {
        while (true) {
            int r = ThreadLocalRandom.current().nextInt(1, 10);
            if (!check[r]) {
                check[r] = true;
                return r;
            }
        }
    }
}