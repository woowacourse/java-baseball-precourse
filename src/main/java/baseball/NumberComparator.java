package baseball;

import static baseball.InputValidator.THREE;

/**
 * 입력된 값을 난수와 비교하여 결과를 내놓는 클래스
 */
public class NumberComparator {

    private final static String NOTHING = "낫싱";
    private final static String ONLY_BALL = "%d볼\n";
    private final static String ONLY_STRIKE = "%d스트라이크\n";
    private final static String BALL_AND_STRIKE = "%d볼 %d스트라이크\n";
    private final static String CORRECT_ANSWER = "3개의 숫자를 모두 맞추셨습니다! 게임 종료.";

    private final String random;
    private final String input;
    private int strikeCount;
    private int ballCount;

    public NumberComparator(String input, String random) {
        this.input = input;
        this.random = random;
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public boolean correctNumbers() {
        for (int i = 0; i < THREE; i++) {
            countStrike(i);
        }
        return showResult();
    }

    private void countStrike(int index) {
        if (input.charAt(index) == random.charAt(index)) {
            strikeCount++;
        } else {
            countBall(index);
        }
    }

    private void countBall(int index) {
        if (random.contains(String.valueOf(input.charAt(index)))) {
            ballCount++;
        }
    }

    private boolean showResult() {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(NOTHING);
        } else if (strikeCount == 0) {
            System.out.printf(ONLY_BALL, ballCount);
        } else if (ballCount == 0) {
            System.out.printf(ONLY_STRIKE, strikeCount);
        } else {
            System.out.printf(BALL_AND_STRIKE, ballCount, strikeCount);
        }
        if (strikeCount == THREE) {
            System.out.println(CORRECT_ANSWER);
            return true;
        }
        return false;
    }

}
