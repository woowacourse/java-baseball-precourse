/**
 * Judgement 클래스는 사용자 입력(input)과 사용자가 맞춰야 하는 정답(target)을 비교하여
 * 볼 카운트, 스트라이크 카운트를 계산합니다.
 */

import java.util.Arrays;
import java.util.List;

public class Judgement {
    private int digit;

    public Judgement(int digit) {
        this.digit = digit;
    }

    private int judgeStrikeCount(List <Integer> input, List <Integer> target) {
        int strikeCount = 0;
        for (int i = 0; i < digit; i++) {
            if (target.get(i).equals(input.get(i))) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    private int judgeBallCount(List <Integer> input, List <Integer> target) {
        int ballCount = 0;
        boolean[] numberInTarget = new boolean[10];
        Arrays.fill(numberInTarget, false);
        for (int i = 0; i < digit; i++) {
            numberInTarget[target.get(i)] = true;
        }
        for (int i = 0; i < digit; i++) {
            if (numberInTarget[input.get(i)]) {
                ballCount += 1;
                numberInTarget[input.get(i)] = false;
            }
        }
        return ballCount;
    }

    public Score judge(List <Integer> input, List <Integer> target) {
        int ballCount = judgeBallCount(input, target);
        int strikeCount = judgeStrikeCount(input, target);
        ballCount -= strikeCount;
        if (ballCount < 0) {
            ballCount = 0;
        }

        Score score = new Score(strikeCount, ballCount);
        return score;
    }

}