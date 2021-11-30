package baseball;

public class Application {
    public static void main(String[] args) {
        do {
            Game.play(RandomNumberGenerator.generateThreeRandomDigits());
        } while (Player.isContinue());
    }
}
