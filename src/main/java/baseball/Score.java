package baseball;

public class Score {
    private int ball;
    private int strike;

    /**
     * 입력값과 정답을 비교해 점수를 계산
     * @param input 입력값
     * @param target 정답
     */
    public void count(String input, String target) {
        ball = 0;
        strike = 0;
        for (int i = 0; i < input.length(); i++) {
            if (target.charAt(i) == input.charAt(i)) {
                strike++;
                continue;
            }
            if (target.contains(String.valueOf(input.charAt(i)))) {
                ball++;
            }
        }
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

}
