package baseball;

public class Game {
    private final Printer printer;
    private final Score score;
    private final Valid valid;

    private String target;

    public Game(Printer printer, Score score, Valid valid) {
        this.printer = printer;
        this.score = score;
        this.valid = valid;
    }

    /** 새 게임을 위한 정답을 준비 */
    public void initNewGame() {
        this.target = valid.newTarget();
    }
}
