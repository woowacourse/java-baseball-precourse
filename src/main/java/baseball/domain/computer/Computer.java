package baseball.domain.computer;

import static baseball.domain.number.BaseBallNumbers.BASEBALL_NUMBERS_LIMIT_SIZE;

import baseball.domain.number.BaseBallNumber;
import baseball.domain.number.BaseBallNumbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private final BaseBallNumbers answerNumbers;

    private Computer(BaseBallNumbers answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public static Computer createWithAnswerNumbersByRandomGenerator() {
        BaseBallNumbers answerNumbers = BaseBallNumbers.createByIntegerNumbers(generateNumbers());
        return new Computer(answerNumbers);
    }

    private static List<Integer> generateNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != BASEBALL_NUMBERS_LIMIT_SIZE) {
            numbers.add(Randoms.pickNumberInRange(BaseBallNumber.MIN_NUMBER, BaseBallNumber.MAX_NUMBER));
        }
        return new ArrayList<>(numbers);
    }
}
