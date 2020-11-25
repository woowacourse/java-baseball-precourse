package domain.player;

public class Player {
    boolean isStartingGame = false;

    public void startGame() {
        isStartingGame = true;
    }

    public boolean isStartingGame() {
        return isStartingGame;
    }
}
