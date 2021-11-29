package baseball;

import static baseball.StringUtil.BALL;
import static baseball.StringUtil.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class GivenNumbersTest {

    @Test
    void 정해진_수와_입력값을_비교해서_결과를_출력한다() {
        Set<Integer> generatedNumbers = Stream.of(1, 2, 3).collect(Collectors.toCollection(LinkedHashSet::new));
        Integer[] inputNumber = {1, 3, 5};

        Map<String, Integer> result = new HashMap<>();
        result.put(STRIKE, 1);
        result.put(BALL, 1);

        GivenNumbers givenNumbers = new GivenNumbers(generatedNumbers);
        assertThat(givenNumbers.operate(inputNumber)).isEqualTo(result);
    }
}
