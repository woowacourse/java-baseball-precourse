package domain;

import java.util.List;
import java.util.Objects;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
public class BaseballNumber {
    public static final int BASEBALL_LIST_SIZE = 3;

    private final List<Integer> baseballNumbers;

    public BaseballNumber(final List<Integer> baseballNumbers) {
        validateSize(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    private void validateSize(List<Integer> baseballNumbers) {
        if (baseballNumbers.size() != BASEBALL_LIST_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber(int index) {
        return baseballNumbers.get(index);
    }

    public boolean contains(int number) {
        return baseballNumbers.contains(number);
    }

    public int indexOf(int number) {
        return baseballNumbers.indexOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseballNumber)) {
            return false;
        }
        BaseballNumber that = (BaseballNumber) o;
        return Objects.equals(baseballNumbers, that.baseballNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballNumbers);
    }
}
