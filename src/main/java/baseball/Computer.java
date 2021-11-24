package baseball;


public class Computer {
    private final BallRepository balls;

    public Computer() {
        RandomNumbers randomNumbers = new RandomNumbers();
        balls = new BallRepository(randomNumbers.getNumbers());
    }

    public BallRepository getBalls() {
        return balls;
    }
}
