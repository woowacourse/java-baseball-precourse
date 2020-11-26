package baseball.domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultBaseballNumbersGenerator implements BaseballNumbersGenerator {

    @Override
    public List<BaseballNumber> generateBaseballNumbers() {
        List<Integer> distinctBaseballNumbers = new ArrayList<>();
        while (distinctBaseballNumbers.size() < BaseballNumbers.BASEBALL_NUMBERS_LENGTH) {
            int newBaseballNumber = RandomUtils.nextInt(BaseballNumber.MIN_BASEBALL_NUMBER,
                    BaseballNumber.MAX_BASEBALL_NUMBER);
            if (distinctBaseballNumbers.contains(newBaseballNumber)) {
                continue;
            }

            distinctBaseballNumbers.add(newBaseballNumber);
        }

        return distinctBaseballNumbers.stream()
                .map(Integer::new)
                .map(BaseballNumber::new)
                .collect(Collectors.toList());
    }
}
