package baseball.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Balls {

    List<Ball> balls;

    public Balls(int firstBall, int secondBall, int thirdBall) {
        balls = new LinkedList<>(Arrays.asList(
                new Ball(firstBall, 0),
                new Ball(secondBall, 1),
                new Ball(thirdBall, 2)
        ));
    }

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
}
