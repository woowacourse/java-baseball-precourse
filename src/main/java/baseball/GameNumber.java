package baseball;

import java.util.HashSet;
import java.util.List;

import static baseball.config.Message.*;
import static baseball.config.Constant.*;

public class GameNumber {
    private final List<Integer> gameNumber;

    public GameNumber(List<Integer> gameNumber) {
        checkNumber(gameNumber);
        this.gameNumber = gameNumber;
    }

    private void checkNumber(List<Integer> gameNumber) {
        isValidLength(gameNumber);
        isBetweenOneAndNine(gameNumber);
        hasDuplicate(gameNumber);
    }

    private void isValidLength(List<Integer> gameNumber) {
        if(gameNumber.size() != NUM_SIZE) {
            throw new IllegalArgumentException(ERR_MSG);
        }
    }

    private void isBetweenOneAndNine(List<Integer> gameNumber) {
        if(!gameNumber.stream().allMatch(num -> num >= MIN_NUM_VALUE && num <= MAX_NUM_VALUE)) {
            throw new IllegalArgumentException(ERR_MSG);
        }
    }

    private void hasDuplicate(List<Integer> gameNumber) {
        HashSet<Integer> hashSet = new HashSet<>(gameNumber);

        if(hashSet.size() != NUM_SIZE) {
            throw new IllegalArgumentException(ERR_MSG);
        }
    }

    public List<Integer> getGameNumber() {
        return gameNumber;
    }
}
