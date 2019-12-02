/*
 * ClassName : GameCheck
 * ClassExplanation : 사용자 입력값과 정답 비교
 * author : Kim SeYun
 * Date : 2019. 12. 02
 * Copyright (c) 2019 SeYun Kim
 */
public class GameCheck {
    static int strike = 0;
    static int ball = 0;

    public GameCheck(int[] computer, int[] user) {
        this.getStrike(computer, user);
        this.getBall(computer, user);
    }

    public int getStrike(int[] computer, int[] user) {              // 스트라이크 체크
        strike = 0;

        for (int i = 0; i < computer.length; i++) {
            if (computer[i] == user[i]) {
                strike++;
            }
        }

        return strike;
    }

    public int getBall(int[] computer, int[] user) {                // 볼 체크
        ball = 0;

        if (user[0] == computer[1] || user[0] == computer[2]) {
            ball++;
        }

        if (user[1] == computer[0] || user[1] == computer[2]) {
            ball++;
        }

        if (user[2] == computer[0] || user[2] == computer[1]) {
            ball++;
        }

        return ball;
    }
}