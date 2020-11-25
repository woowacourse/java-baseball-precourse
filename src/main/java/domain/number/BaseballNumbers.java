package domain.number;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballNumbers {

    private final List<BaseballNumber> baseballNumbers;

    private BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballNumbers generateAutomatic() {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        while (baseballNumbers.size() != 3) {
            BaseballNumber baseballNumber = BaseballNumber.of(RandomUtils.nextInt(1, 9));
            if (!baseballNumbers.contains(baseballNumber)) {
                baseballNumbers.add(baseballNumber);
            }
        }
        return new BaseballNumbers(baseballNumbers);
    }

    public List<Integer> getBaseballNumbers() {
        return baseballNumbers.stream()
                .map(BaseballNumber::getBaseballNumber)
                .collect(Collectors.toList());
    }
}
