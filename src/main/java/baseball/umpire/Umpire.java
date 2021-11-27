package baseball.umpire;


import java.util.Arrays;

import static baseball.Constants.maxNumberLen;

public class Umpire {
    public int strike;
    public int ball;

    public Umpire() {
        init();
    }

    public void init() {
        strike = 0;
        ball = 0;
    }

    public void checkResult(int[] target, int[] input) {
        isBall(target, input);
        isStrike(target, input);
        isNothing();
        System.out.println();
    }

    public boolean isEnd() {
        if (strike == maxNumberLen) {
            return true;
        }
        return false;
    }

    private void isNothing() {
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
    }

    private void isStrike(int[] target, int[] input) {
        for (int i = 0; i < maxNumberLen; i++) {
            if (target[i] == input[i]) {
                strike += 1;
            }
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
    }

    private void isBall(int[] target, int[] input) {
        for (int i = 0; i < maxNumberLen; i++) {
            if (contains(target, input[i], i)) {
                ball += 1;
            }
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
    }


    public boolean contains(int[] array, int key, int index) {
        for (int i = 0; i < array.length; i++) {
            if (i != index && key == array[i]) {
                return true;
            }
        }
        return false;
    }


}
