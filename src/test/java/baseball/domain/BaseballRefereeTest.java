package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseballRefereeTest {

    @DisplayName("[1, 2, 3]이 주어지고 inputNumbers 중 같은 수만 n개 존재할 경우 n볼이다.")
    @ParameterizedTest(name = "{index} -> {0}인 경우 {1}")
    @CsvSource({"231, 3볼", "235, 2볼", "247, 1볼"})
    void refereeBall(String input, String result) {
        // given
        BaseballReferee baseballReferee = new BaseballReferee();
        List<Integer> inputNumbers = toList(input);

        // when
        BaseballState baseballState = baseballReferee.referee(Arrays.asList(1, 2, 3), inputNumbers);

        // then
        assertThat(baseballState.getMessage()).isEqualTo(result);
    }

    @DisplayName("[1, 2, 3]이 주어지고 inputNumbers 중 같은 자리에 같은 수가 존재하는 경우 n스트라이크이다.")
    @ParameterizedTest(name = "{index} -> {0}인 경우 {1}")
    @CsvSource({"123, 3스트라이크", "124, 2스트라이크", "146, 1스트라이크"})
    void refereeStrike(String input, String result) {
        // given
        BaseballReferee baseballReferee = new BaseballReferee();
        List<Integer> inputNumbers = toList(input);

        // when
        BaseballState baseballState = baseballReferee.referee(Arrays.asList(1, 2, 3), inputNumbers);

        // then
        assertThat(baseballState.getMessage()).isEqualTo(result);
    }

    @DisplayName("[1, 2, 3]이 주어지고 inputNumbers 중 자리가 다른 숫자 n개, 자리와 숫자 모두 같은 m개 존재하는 경우 n볼 m스트라이크이다.")
    @ParameterizedTest(name = "{index} -> {0}인 경우 {1}")
    @CsvSource({"213, 2볼 1스트라이크", "137, 1볼 1스트라이크"})
    void refereeBallAndStrike(String input, String result) {
        // given
        BaseballReferee baseballReferee = new BaseballReferee();
        List<Integer> inputNumbers = toList(input);

        // when
        BaseballState baseballState = baseballReferee.referee(Arrays.asList(1, 2, 3), inputNumbers);

        // then
        assertThat(baseballState.getMessage()).isEqualTo(result);
    }

    @DisplayName("[1, 2, 3]이 주어지고 inputNumbers 중 같은 수가 존재하지 않는 경우 낫싱이다.")
    @ParameterizedTest(name = "{index} -> {0}인 경우 {1}")
    @CsvSource({"456, 낫싱"})
    void refereeNotting(String input, String result) {
        // given
        BaseballReferee baseballReferee = new BaseballReferee();
        List<Integer> inputNumbers = toList(input);

        // when
        BaseballState baseballState = baseballReferee.referee(Arrays.asList(1, 2, 3), inputNumbers);

        // then
        assertThat(baseballState.getMessage()).isEqualTo(result);
    }

    private List<Integer> toList(String input) {
        return Arrays.stream(input.split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}