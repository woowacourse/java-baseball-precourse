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

    /** 입력을 요청 */
    public void readyForInput() {
        printer.enterNumber();
    }

    /** 입력값으로 게임을 진행 */
    public boolean playing(String input) {
        score.count(valid.gameNumber(input), target);
        printer.ballAndStrike(score.getBall(), score.getStrike());

        if (target.equals(input)) {
            printer.gameOver(target.length());
            return false;
        }
        return true;
    }
}
