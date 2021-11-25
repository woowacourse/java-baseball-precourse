package baseball;

public class Ball {

    private final int value;
    private final int index;

    public Ball(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public PlayType play(Ball opponentBall) {
        return PlayType.STRIKE;
    }
}
