package baseball.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    List<Ball> balls;

    /**
     * 초기 index는 1부터 시작합니다
     */
    public Balls(int firstBall, int secondBall, int thirdBall) {
        balls = new LinkedList<>(Arrays.asList(
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
                .map(opponentBall::play)
                .collect(Collectors.toList());
    }

    // N:1 관계 하나의 볼과 게임을 한다
    public PlayType play(Ball opponentBall) {
        List<PlayType> playTypes = getPlayTypes(opponentBall);
        if (hasStrike(playTypes)) {
            return PlayType.STRIKE;
        }
        if (hasBall(playTypes)) {
            return PlayType.BALL;
        }
        return PlayType.NOTHING;
    }

    // N:M 관계 여러개의 볼과 게임을 한다
    public PlayTypes play(Balls computerBalls) {
        List<PlayType> playTypeList = balls.stream().map(computerBalls::play).collect(Collectors.toList());
        return new PlayTypes(playTypeList);
    }
}
