package utils;

public class Game {

    private Game() {
    }

    public static Game of() {
        return new Game();
    }
}
