/*
 * @(#)BaseballGame.java       0.2 2019/03/23
 */

import java.util.*;

/**
 * 숫자야구게임을 진행하는 클래스
 *
 * @author 이도원
 * @version 0.2 2019/03/23
 */
public class BaseballGame {

    /* 숫자야구게임의 숫자 갯수 */
    private static final int NUMBER = 3;

    /* 숫자의 범위 */
    private static final int NUMBER_RANGE = 9;

    /* 숫자의 최소 값 */
    private static final int MIN_NUMBER = 1;

    /* 선택한 숫자들을 연결한 문자열 */
    private String numbers;

    /**
     * BaseballGame 클래스의 생성자
     */
    public BaseballGame() {
    }

    /**
     * 숫자야구게임을 진행하는 메소드
     */
    public void start() {
        System.out.print("게임을 시작합니다!\n");
        selectNumbers();
    }

    /* 임의의 수 3개를 선택하는 메소드. */
    private void selectNumbers() {
        Random random = new Random();
        HashSet<Integer> set = new HashSet<>();
        numbers = "";

        /* 임의의 수가 3개 선택될 때까지 반복 */
        while (numbers.length() < NUMBER) {

            /* 1~9 사이의 임의의 정수 생성 */
            int randomNumber = random.nextInt(NUMBER_RANGE) + MIN_NUMBER;

            if (!set.contains(randomNumber)) {

                /* randomNumber 가 이미 선택된 수와 같지 않은 경우에 실행 */
                numbers += randomNumber;
                set.add(randomNumber);
            }
        }

    }
}