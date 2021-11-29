package baseball;

public class Application {
    public static void main(String[] args) {
        do {
            PlayBall.play(RandomNumberGenerator.generateThreeRandomDigits());
        } while (PlayBall.isContinue());
    }
}
