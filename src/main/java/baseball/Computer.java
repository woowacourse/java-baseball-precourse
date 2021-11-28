package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    public static final String RESULT_NOTHING = "낫싱";

    private final Balls balls = new Balls();
    private CompareResult compareResult = new CompareResult();

    public Balls createRandomBalls() {
        while (!balls.isFull()) {
            Ball newBall = new Ball(Randoms.pickNumberInRange(0, 9));
            if (!balls.contains(newBall)) {
                balls.add(newBall);
            }
        }
        return balls;
    }

    public void makeJudge(Balls playerBalls) {
        compareResult = balls.compare(playerBalls);

        if (compareResult.isNothing()) {
            System.out.println(RESULT_NOTHING);
        }
        if (compareResult.onlyBalls()) {
            System.out.printf("%d 볼", compareResult.getBall());
        }
        if (compareResult.onlyStrikes()) {
            System.out.printf("%d 스트라이크", compareResult.getStrike());
        }
        System.out.printf("%d 스트라이크 %d 볼", compareResult.getStrike(), compareResult.getBall());
    }

    public boolean gameFinished(Balls playerBalls) {
        compareResult = balls.compare(playerBalls);

        return compareResult.getStrike() == Balls.MAX_LENGTH;
    }
}
