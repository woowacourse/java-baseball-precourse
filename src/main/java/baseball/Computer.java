package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private final Balls balls = new Balls();

    public Balls createRandomBalls() {
        while (!balls.isFull()) {
            Ball newBall = new Ball(Randoms.pickNumberInRange(0, 9));
            if (!balls.contains(newBall)) {
                balls.add(newBall);
            }
        }
        return balls;
    }
}
