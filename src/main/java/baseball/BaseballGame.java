package baseball;

import domain.BaseballNumber;
import java.util.List;
import utils.RandomNumbers;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
public class BaseballGame {
    public static final int BASEBALL_LIST_SIZE = 3;

    private final BaseballNumber baseballNumber;

    public BaseballGame() {
        this.baseballNumber = new BaseballNumber(nonDuplicateNumber());
    }

    private List<Integer> nonDuplicateNumber() {
        return RandomNumbers.getInstance(BASEBALL_LIST_SIZE);
    }

    public boolean exists(BaseballNumber playerBaseballNumber) {
        if (baseballNumber.equals(playerBaseballNumber)) {
            /**
             * TODO : 정답을 맞춘 경우 메시지 출력
             */
            return true;
        }
        return false;
    }
}
