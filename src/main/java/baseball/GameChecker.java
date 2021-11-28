package baseball;

import java.util.List;

public class GameChecker implements Checker {

    @Override
    public int checkStrike(List<Integer> targetNumber, List<Integer> numberToCheck) {
        int strikes = 0;
        int len = targetNumber.size();
        for (int index = 0; index < len; index++) {
            if (targetNumber.get(index).equals(numberToCheck.get(index))) {
                strikes++;
            }
        }
        return strikes;
    }

    @Override
    public int checkBall(List<Integer> targetNumber, List<Integer> numberToCheck) {
        int balls = 0;
        int len = numberToCheck.size();
        for (int index = 0; index < len; index++) {
            int number = numberToCheck.get(index);
            if (isIn(targetNumber, number, index)) {
                balls++;
            }
        }
        return balls;
    }

    private boolean isIn(List<Integer> targetNumber, int numberToCheck, int index) {
        int len = targetNumber.size();
        for (int i = 0; i < len; i++) {
            if (i == index) continue;
            if (targetNumber.get(i) == numberToCheck) {
                return true;
            }
        }
        return false;
    }
}
