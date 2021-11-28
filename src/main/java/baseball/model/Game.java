package baseball.model;

public class Game {
    private Computer computer;
    private Player player;
    private Hint hint;

    public Game(Computer computer, Player player, Hint hint) {
        this.computer = computer;
        this.player = player;
        this.hint = hint;
    }
}
