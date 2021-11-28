package baseball;

import java.util.List;

public interface GameChecker {
    int checkStrike(List<Integer> targetNumber, List<Integer> numberToCheck);
    int checkBall(List<Integer> targetNumber, List<Integer> numberToCheck);
}
