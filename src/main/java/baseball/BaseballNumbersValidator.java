package baseball;

public class BaseballNumbersValidator {
    static final int BASEBALL_NUMBER_LENGTH = 3;
    static final int BASEBALL_NUMBER_MINIMUM = 1;
    static final int BASEBALL_NUMBER_MAXIMUM = 9;

    public static boolean isValid(BaseballNumbers baseballNumbers) {
        return isRightLength(baseballNumbers)
                && isDistinct(baseballNumbers)
                && isRightRangeAndIsNumeric(baseballNumbers);
    }

    private static boolean isRightLength(BaseballNumbers baseballNumbers) {
        return baseballNumbers.getBaseballNumbers().size() == BASEBALL_NUMBER_LENGTH;
    }

    private static boolean isDistinct(BaseballNumbers baseballNumbers) {
        return BASEBALL_NUMBER_LENGTH == baseballNumbers.getBaseballNumbers()
                .stream()
                .distinct()
                .count();
    }

    private static boolean isRightRangeAndIsNumeric(BaseballNumbers baseballNumbers) {
        return BASEBALL_NUMBER_LENGTH == baseballNumbers.getBaseballNumbers()
                .stream()
                .filter(baseballNumber -> BASEBALL_NUMBER_MINIMUM <= baseballNumber
                        && baseballNumber <= BASEBALL_NUMBER_MAXIMUM)
                .count();
    }
}
