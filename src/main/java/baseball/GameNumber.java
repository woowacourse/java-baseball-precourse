package baseball;

import java.util.HashSet;
import java.util.List;

import static baseball.InitialSetting.ERR_MSG;
import static baseball.InitialSetting.NUM_SIZE;

public class GameNumber {
    private final List<Integer> gameNumber;

    public GameNumber(List<Integer> gameNumber) {
        checkNumber(gameNumber);
        this.gameNumber = gameNumber;
    }

    private void checkNumber(List<Integer> gameNumber) {
        isValidLength(gameNumber);
        hasDuplicate(gameNumber);
    }

    private void isValidLength(List<Integer> gameNumber) {
        if(gameNumber.size() != NUM_SIZE) {
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
