package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {

    @DisplayName("BaseballGame을 시작하는 기능을 테스트한다 ")
    @Test
    void testBaseballGamePlayFunction() {
        //given
        List<BaseballNumber> baseballNumbers = Arrays.asList(1, 2, 3).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList());
        //when
        BaseballGame baseballGame = BaseballGame.play(() -> baseballNumbers);

        //then
        assertThat(baseballGame).extracting("playing").isEqualTo(true);
        assertThat(baseballGame).extracting("baseballNumbers")
                .usingRecursiveComparison()
                .isEqualTo(new BaseballNumbers(baseballNumbers));
    }

    @DisplayName("스트라이크 개수를 세는 기능을 테스트한다 ")
    @ParameterizedTest
    @CsvSource(value = {"123:3", "124:2", "135:1", "234:0"}, delimiter = ':')
    void testCountStrikeFunction(String inputNumber, int expectedStrikeNumber) {
        //given
        List<BaseballNumber> answerBaseballNumbers = Arrays.asList(1, 2, 3).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList());
        BaseballGame baseballGame = BaseballGame.play(() -> answerBaseballNumbers);

        BaseballNumbers baseballNumbers = new BaseballNumbers(Arrays.stream(inputNumber.split(""))
                .map(Integer::new)
                .map(BaseballNumber::new)
                .collect(Collectors.toList()));

        //when
        int strikeNumber = baseballGame.countStrike(baseballNumbers);

        //then
        assertThat(strikeNumber).isEqualTo(expectedStrikeNumber);
    }
}
