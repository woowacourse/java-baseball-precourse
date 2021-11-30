package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(Game.getRandomValue());

        while (true) {
            String userInput = Input.inputUserNumber();

            if (!game.checkNumber(userInput)) {
                continue;
            }

            if (Input.inputEndNumber()) {
                break;
            }

            game = new Game(Game.getRandomValue());
        }
    }
}