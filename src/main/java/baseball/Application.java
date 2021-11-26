package baseball;

public class Application {

    public static void main(String[] args) {
        baseball.Game game = new baseball.Game(new Computer(), new Validation());
        game.startGame();
    }
}
