package baseball;

import utils.RandomUtils;
import java.util.Scanner;

public class BaseballGame {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int ANSWER_LENGTH = 3;
    private static final int ALL_STRIKE_CNT = 3;
    private static final char RESTART_CODE = '1';
    private static final char FINISH_CODE = '2';
    private String guess;
    private Player player;
    private Printer printer;
    private Referee referee;
    private String answer;
    private int ballCnt;
    private int strikeCnt;
    private char progress;
    private boolean allStrike;
    private boolean progressGame;

    public BaseballGame(Scanner scanner) {
        player = new Player(scanner);
        referee = new Referee();
        printer = new Printer();
    }

    public void initGame () {
        answer = "";
        generateAnswer();
        guess = "";
        progress = '\u0000';
        ballCnt = 0;
        strikeCnt = 0;
        allStrike = false;
        progressGame = true;
    }

    public void run() {
        do {
            start();
        } while (progressGame);
    }

    public void start() {
        initGame();
        while (!allStrike) {
            askGuess();
            referee.compareNumber(answer, guess);
            ballCnt = referee.getBallCnt();
            strikeCnt = referee.getStrikeCnt();
            printer.printHint(ballCnt, strikeCnt);
            isAllStrike(strikeCnt);
        }
        finish();
    }

    public void generateAnswer() {
        while (answer.length() < ANSWER_LENGTH) {
            int randomNum = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
            String randomStr = Integer.toString(randomNum);
            if (!isSameStr(answer, randomStr)) {
                answer += randomStr;
            }
        }
    }

    public void askGuess() {
        printer.printStartMessage();
        guess = player.inputGuess();
    }

    public void askProgress() {
        printer.printProgressMessage();
        progress = player.inputProgress();
    }

    public boolean isSameStr(String answer, String randomStr) {
        if (answer.contains(randomStr)) {
           return true;
        } else {
            return false;
        }
    }

    public void isAllStrike(int strikeCnt) {
        if (strikeCnt == ALL_STRIKE_CNT) {
            allStrike = true;
        } else {
            allStrike = false;
        }
    }

    public void finish() {
        printer.printFinishMessage();
        askProgress();
        if (progress == RESTART_CODE) {
            progressGame = true;
        } else if (progress == FINISH_CODE) {
            progressGame = false;
        }
    }
}