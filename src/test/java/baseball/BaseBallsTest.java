package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BaseBallsTest {

    @Test
    @DisplayName("야구공 일급컬렉션 생성")
    void test1() {
        BaseBalls baseBalls = new BaseBalls(Arrays.asList(1, 2, 3));

        assertThat(baseBalls).isEqualTo(new BaseBalls(Arrays.asList(1, 2, 3)));
    }


    private static Stream<List<Integer>> sourceInvalidSize() {
        return Stream.of(Arrays.asList(1, 2), Arrays.asList(1, 2, 3, 4));
    }

    @DisplayName("야구공 일급 컬렉션의 사이즈가 3이 아닌경우")
    @ParameterizedTest
    @MethodSource("sourceInvalidSize")
    void test2(List<Integer> numbers) {
        assertThatThrownBy(() -> new BaseBalls(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("야구공은 3개만 허용됩니다.");
    }

    @DisplayName("스트라이크 인지 검사")
    @Test
    void isStrike() {
        BaseBalls baseBalls = new BaseBalls(Arrays.asList(1, 2, 3));

        BaseBall firstStrike = new BaseBall(1, 1);
        BaseBall secondStrike = new BaseBall(2, 2);
        BaseBall thirdStrike = new BaseBall(3, 3);

        assertThat(baseBalls.isStrike(firstStrike)).isTrue();
        assertThat(baseBalls.isStrike(secondStrike)).isTrue();
        assertThat(baseBalls.isStrike(thirdStrike)).isTrue();
    }

    @DisplayName("볼 인지 검사")
    @Test
    void isBall() {
        BaseBalls baseBalls = new BaseBalls(Arrays.asList(1, 2, 3));

        BaseBall ball = new BaseBall(2, 1);

        assertThat(baseBalls.isBall(ball)).isTrue();
    }
}