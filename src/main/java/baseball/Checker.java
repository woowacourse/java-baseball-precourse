package baseball;

import java.util.List;

public interface Checker {
    int checkStrike(List<Integer> targetNumber, List<Integer> numberToCheck);
    int checkBall(List<Integer> targetNumber, List<Integer> numberToCheck);
}
