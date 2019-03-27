package com.isbee.game.baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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
    private BaseballInput baseballInput;

    public MyBaseballGame() {
        baseballInfo = BaseballInfo.INSTANCE;
        baseballInput = new UserInput(baseballInfo.getDigitNum());
    }

    /** 플레이어가 게임을 완전히 종료하기 전까지, 계속해서 게임을 진행한다 */
    @Override
    public void play() {
        do {
            baseballInfo.setComNum(generateRandomNum());
            System.out.println("com:" + baseballInfo.getComNum());
            playOneGame();
        } while (playMoreOrNot());
    }

    /**
     * 플레이어의 숫자를 BaseballInput에게 위임하여 가져온다
     *
     * @return 플레이어 입력 숫자
     */
    @Override
    public int getUserNum() {
        return baseballInput.getUserNum();
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
     * 생성된 난수와 플레이어의 입력 숫자를 비교한 결과를 리턴. 시간복잡도 = O(NlogN), N = 야구 게임 자리수 (default = 3)
     *
     * @return 3 스트라이크 성공 여부
     */
    @Override
    public boolean compareNum() {
        int strikeAndBall[] = new int[2];       // [0]: strike, [1]: ball

        countStrikeAndBall(strikeAndBall, baseballInfo.getComNum(), baseballInfo.getUserNum());
        /* TODO: 결과 출력 */
        return doesGuessCorrect(strikeAndBall[0]);
    }

    /**
     * strike/ball 갯수를 카운트한다.
     * O(N^2)의 완전탐색 대신, Set을 사용해 O(NlogN)으로 카운트.
     *
     * @param strikeAndBall strike/ball 갯수를 저장하는 배열
     * @param com           사용자가 맞춰야 할 숫자
     * @param user          사용자가 입력한 숫자
     */
    private void countStrikeAndBall(int strikeAndBall[], int com, int user) {
        Set<Integer> comSet = new HashSet<>();
        Set<Integer> userSet = new HashSet<>();
        int divider = getUpperBound();

        while (divider > 0) {
            int c = com / divider;
            int u = user / divider;
            if (c == u) {
                strikeAndBall[0]++;
            } else {            // strike가 아닌 숫자는 set에 넣은 뒤 ball 체크 하는데 쓴다.
                comSet.add(c);
                userSet.add(u);
            }
            com %= divider;
            user %= divider;
            divider /= 10;
        }
        countBall(strikeAndBall, comSet, userSet);
    }

    /**
     * Set에 저장된 숫자를 비교하여 ball 갯수를 카운트한다
     *
     * @param strikeAndBall strike/ball 갯수를 저장하는 배열
     * @param comSet        사용자가 맞춰야할 숫자 중, strike가 아닌 나머지
     * @param userSet       사용자의 입력 숫자 중, strike가 아닌 나머지
     * */
    private void countBall(int strikeAndBall[], Set<Integer> comSet, Set<Integer> userSet) {
        for (int num : userSet) {
            if (comSet.contains(num)) {
                strikeAndBall[1]++;
                comSet.remove(num);
            }
        }
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
     * 3 strike 여부
     *
     * @param strikeNum strike 갯수
     * */
    private boolean doesGuessCorrect(int strikeNum) {
        return strikeNum == baseballInfo.getDigitNum() ? true : false;
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

    /** 정답을 맞출때 까지 게임을 계속한다 */
    private void playOneGame() {
        do {
            baseballInfo.setUserNum(getUserNum());
        } while (!compareNum());
    }

    /**
     * 야구 게임 재시작 여부를 BaseballInput에 위임하여 리턴
     *
     * @return 재시작 여부
     * */
    private boolean playMoreOrNot() {
        return baseballInput.playMoreOrNot();
    }
}