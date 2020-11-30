package baseball.model;

import org.junit.jupiter.api.RepeatedTest;
import utils.ValidationUtils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

public class DataGeneratorTest {
    private static final int NUMBER_OF_TEST_CASES = 9000;
    private static final int NUMBER_OF_DIGITS = 3;
    private static final int MIN_DIGIT = 1;
    private static final int MAX_DIGIT = 9;

    @RepeatedTest(NUMBER_OF_TEST_CASES)
    public void generateRandomDigitList() {
        ParameterSet parameterSet =
                new ParameterSet(NUMBER_OF_DIGITS, MIN_DIGIT, MAX_DIGIT);

        List<Integer> randomDigitList =
                DataGenerator.generateRandomDigitList(parameterSet);

        String randomDigits = randomDigitList.stream().map(String::valueOf)
                .collect(Collectors.joining());

        String validRandomDigits =
                ValidationUtils.validateInputInProgress(randomDigits, parameterSet);

        assertThat(randomDigits).isEqualTo(validRandomDigits);
    }
}
