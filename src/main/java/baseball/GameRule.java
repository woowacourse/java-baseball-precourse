package baseball;

import java.util.ArrayList;

public class GameRule {

    private final ArrayList<Integer> answer;
    private final ArrayList<Integer> userInput;
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final int NUM_LEN = 3;
    private int strike = 0;
    private int ball = 0;

    public GameRule(ArrayList<Integer> answer, ArrayList<Integer> userInput) {
        this.answer = answer;
        this.userInput = userInput;
        gameStatCounter();
        getResult();
    }

    private void gameStatCounter() {
        for (int index = 0; index < NUM_LEN; index++) {
            if (isStrike(index)) {
                strike++;
                continue;
            }
            if (isBall(index)) {
                ball++;
            }
        }
    }

    private boolean isStrike(int index) {

        return answer.get(index).equals(userInput.get(index));
    }

    private boolean isBall(int index) {

        return answer.contains(userInput.get(index));
    }

    private boolean isNothing() {

        return strike == 0 && ball == 0;
    }

    public boolean isWin() {

        return strike == NUM_LEN;
    }

    public void printStatCount() {
        if (strike != 0 && ball != 0) {
            System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
            return;
        }
        if (strike != 0) {
            System.out.println(strike + STRIKE_MESSAGE);
            return;
        }
        if (ball != 0) {
            System.out.println(ball + BALL_MESSAGE);
        }
    }


    public void getResult() {
        if (isNothing()) {
            System.out.println(NOTHING_MESSAGE);
        } else {
            printStatCount();
        }
        if (isWin()) {
            System.out.println(WIN_MESSAGE);
        }
    }

}
