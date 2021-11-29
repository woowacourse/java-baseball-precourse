package baseball;

// 사용자의 입력이 정답과 얼마나 비슷한지를 나타내는 자료구조.
public class Data {

    private int strike;
    private int ball;

    public Data() {
        strike = 0;
        ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    // 스트라이크 추가
    public void addStrike() {
        strike++;
    }

    // 볼 추가
    public void addBall() {
        ball++;
    }

    boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    boolean isCorrect() {
        return strike == 3;
    }

}
