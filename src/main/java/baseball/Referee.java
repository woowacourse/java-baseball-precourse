package baseball;

import enums.GameProcess;
import enums.RefereeCall;

public class Referee {

    public int[] comparePlayerWithComputer(String playerNumber, String computerNumber) {
        return getStrikeAndBallCount(playerNumber, computerNumber);
    }

    public int[] getStrikeAndBallCount(String playerNumber, String computerNumber) {
        int ball = GameProcess.NO_COUNT.getValue();
        int strike = GameProcess.NO_COUNT.getValue();
        String[] playerDigitArr = playerNumber.split("");
        for (int i = 0; i < playerDigitArr.length; i++) {
            int indexOfSameDigitOfComputerNumber =
                    getIndexOfSameDigitOfComputerNumber(playerDigitArr[i], computerNumber);
            strike += getStrikeCount(indexOfSameDigitOfComputerNumber, i);
            ball += getBallCount(indexOfSameDigitOfComputerNumber, i);
        }
        return new int[] {strike, ball};
    }

    public int getIndexOfSameDigitOfComputerNumber(String playerDigit, String computerNumber) {
        if (computerNumber.contains(playerDigit)) {
            return computerNumber.indexOf(playerDigit);
        }
        return -1;
    }

    public int getStrikeCount(int indexOfSameDigitOfComputerNumber,
                              int indexOfSameDigitOfPlayerNumber) {
        if (indexOfSameDigitOfComputerNumber == indexOfSameDigitOfPlayerNumber) {
            return 1;
        }
        return GameProcess.NO_COUNT.getValue();
    }

    public int getBallCount(int indexOfSameDigitOfComputerNumber,
                            int indexOfSameDigitOfPlayerNumber) {
        if (indexOfSameDigitOfComputerNumber != indexOfSameDigitOfPlayerNumber
                && indexOfSameDigitOfComputerNumber >= GameProcess.NO_COUNT.getValue()) {
            return 1;
        }
        return GameProcess.NO_COUNT.getValue();
    }

    public String getHint(int strike, int ball) {
        StringBuilder hint = new StringBuilder("");
        if (strike == GameProcess.NO_COUNT.getValue() && ball == GameProcess.NO_COUNT.getValue()) {
            hint.append(RefereeCall.NOTHING.getCall());
        }
        if (ball != GameProcess.NO_COUNT.getValue()) {
            hint.append(ball + RefereeCall.BALL.getCall());
        }
        if (strike != GameProcess.NO_COUNT.getValue()) {
            hint.append(strike + RefereeCall.STRIKE.getCall());
        }
        return hint.toString();
    }
}
