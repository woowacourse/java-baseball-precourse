package baseball.model;

import java.util.*;
import java.util.stream.Collectors;

import static baseball.constant.BallConstant.BALL_SIZE;

public class Balls {

    List<Ball> balls;

    public Balls(int ballsInput) {
        String[] balls = String.valueOf(ballsInput).split("");
        int firstBall = Integer.parseInt(balls[0]);
        int secondBall = Integer.parseInt(balls[1]);
        int thirdBall = Integer.parseInt(balls[2]);
        this.balls = createBalls(firstBall, secondBall, thirdBall);
    }

    /**
     * 초기 index는 1부터 시작합니다
     */
    public Balls(int firstBall, int secondBall, int thirdBall) {
        balls = createBalls(firstBall, secondBall, thirdBall);
    }

    public Balls(Set<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        int[] ballNumbers = new int[BALL_SIZE];
        for (int i = 0; i < BALL_SIZE; i++) {
            ballNumbers[i] = iterator.next();
        }
        int firstBall = ballNumbers[0];
        int secondBall = ballNumbers[1];
        int thirdBall = ballNumbers[2];
        balls = createBalls(firstBall, secondBall, thirdBall);
    }

    private List<Ball> createBalls(int firstBall, int secondBall, int thirdBall) {
        return new LinkedList<>(Arrays.asList(
                new Ball(firstBall, 1),
                new Ball(secondBall, 2),
                new Ball(thirdBall, 3)
        ));
    }

    private boolean hasBall(List<PlayType> playTypes) {
        return playTypes.stream()
                .anyMatch(PlayType.BALL::equals);
    }

    private boolean hasStrike(List<PlayType> playTypes) {
        return playTypes.stream()
                .anyMatch(PlayType.STRIKE::equals);
    }

    private List<PlayType> getPlayTypes(Ball opponentBall) {
        return balls.stream()
                .map(opponentBall::compare)
                .collect(Collectors.toList());
    }

    // N:1 관계: 하나의 볼과 게임을 한다
    public PlayType compare(Ball opponentBall) {
        List<PlayType> playTypes = getPlayTypes(opponentBall);
        if (hasStrike(playTypes)) {
            return PlayType.STRIKE;
        }
        if (hasBall(playTypes)) {
            return PlayType.BALL;
        }
        return PlayType.NOTHING;
    }

    // N:M 관계: 여러개의 볼과 게임을 한다
    public PlayTypes compare(Balls computerBalls) {
        List<PlayType> playTypeList = balls.stream()
                .map(computerBalls::compare)
                .collect(Collectors.toList());
        return new PlayTypes(playTypeList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Balls)) return false;
        Balls balls1 = (Balls) o;
        return Objects.equals(balls, balls1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }

    @Override
    public String toString() {
        return "Balls{" +
                "balls=" + balls +
                '}';
    }
}
