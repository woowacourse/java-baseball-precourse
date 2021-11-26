package baseball;

import domain.Game;

public class Application {
    public static void main(String[] args) {
        Game newGame = new Game();
        System.out.println(newGame.answerNumbers);
    }
}
