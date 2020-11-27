package baseball;

import enums.RefereeCall;

public class Referee {

    public int[] comparePlayerWithComputer(String playerNumber, String computerNumber) {
        return getStrikeAndBallCount(playerNumber, computerNumber);
    }

    public int[] getStrikeAndBallCount(String playerNumber, String computerNumber) {
        int ball = 0;
        int strike = 0;
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
        return 0;
    }

    public int getBallCount(int indexOfSameDigitOfComputerNumber, int indexOfSameDigitOfPlayerNumber) {
        if (indexOfSameDigitOfComputerNumber != indexOfSameDigitOfPlayerNumber && indexOfSameDigitOfComputerNumber >= 0) {
            return 1;
        }
        return 0;
    }

    public String getHint(int strike, int ball) {
        StringBuilder hint = new StringBuilder("");
        if (strike == 0 && ball == 0) {
            hint.append(RefereeCall.NOTHING.getCall());
        }
        if (ball != 0) {
            hint.append(ball + RefereeCall.BALL.getCall());
        }
        if (strike != 0) {
            hint.append(strike + RefereeCall.STRIKE.getCall());
        }
        return hint.toString();
    }
}
