package baseball.model;

public class Game {
    private Computer computer;
    private Player player;
    private Hint hint;

    public Game() {
        this.computer = new Computer();
        this.player = new Player();
        this.hint = new Hint();
    }

    public Computer getComputer() {
        return computer;
    }

    public Player getPlayer() {
        return player;
    }

    public Hint getHint() {
        return hint;
    }
}
