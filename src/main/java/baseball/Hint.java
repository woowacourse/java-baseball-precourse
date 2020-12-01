package baseball;

import java.util.ArrayList;

public class Hint {
    private final ArrayList<Integer> targetNum;
    private ArrayList<Integer> playerNum;
    private int numBall = 0;
    private int numStrike = 0;
    private String hint;
    private boolean isSuccess = false;
    private static final String isBall = "볼 ";
    private static final String isStrike = "스트라이크 ";
    private static final String nothing = "낫싱";
    private static final String isTarget = "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public Hint(ArrayList<Integer> targetNum) {
        this.targetNum = targetNum;
    }

    private void getPlayerNumber(ArrayList<Integer> playerNum) {
        this.playerNum = playerNum;
    }

    public boolean getResult() {
        return isSuccess;
    }

    public String getHint(ArrayList<Integer> playerNumber) {
        initStatus();
        getPlayerNumber(playerNumber);
        checkNum();
        makeHint();
        return hint;
    }

    private void initStatus() {
        numStrike = 0;
        numBall = 0;
    }

    private void checkNum() {
        for (int digit = 0; digit < 3; digit++) {
            checkBall(digit);
        }
    }

    private void checkBall(int index) {
        boolean isStrike;
        if (targetNum.contains(playerNum.get(index))) {
            isStrike = checkStrike(index);
            if (!isStrike) {
                numBall++;
            }
        }
    }

    private boolean checkStrike(int index) {
        if (targetNum.get(index) == playerNum.get(index)) {
            numStrike++;
            return true;
        }

        return false;
    }

    private void makeHint() {
        if (numStrike == 3) {
            isSuccess = true;
            hint = String.valueOf(numStrike).concat(isStrike).concat(isTarget);
            return;
        }

        if (numBall == 0 && numStrike == 0) {
            hint = nothing;
            return;
        }

        if (numBall == 0) {
            hint = String.valueOf(numStrike).concat(isStrike);
            return;
        }

        if (numStrike == 0) {
            hint = String.valueOf(numBall).concat(isBall);
            return;
        }

        hint = String.valueOf(numBall).concat(isBall);
        hint = hint.concat(String.valueOf(numStrike)).concat(isStrike);
    }
}
