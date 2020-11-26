package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        //        then
        assertThat(baseballGame).extracting("playing").isEqualTo(true);
        assertThat(baseballGame).extracting("baseballNumbers")
                .usingRecursiveComparison()
                .isEqualTo(new BaseballNumbers(baseballNumbers));
    }
}
