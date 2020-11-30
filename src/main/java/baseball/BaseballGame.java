package baseball;

import utils.RandomUtils;

import java.util.Scanner;

public class BaseballGame {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int ALL_STRIKE_CNT = 3;
    private static final char RESTART_CODE = '1';
    private static final char FINISH_CODE = '2';
    private boolean allStrike;
    private boolean progressGame;
    public int ballCnt;
    public int strikeCnt;
    public char progress;
    public String answer;
    public String guess;
    public Player player;
    public Printer printer;
    public Referee referee;

    public BaseballGame(Scanner scanner) {
        player = new Player(scanner);
        referee = new Referee();
        printer = new Printer();
    }

    public void run() {
    }

    public void initGame () {
    }

    public void start() {
    }

    public String generateAnswer() {
        return answer;
    }

    public void isAllStrike(int strikeCnt) {

    }

    public void finish() {
    }

    public void askGuess() {
    }

    public void askProgress() {
    }

}