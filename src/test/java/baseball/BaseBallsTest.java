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

    @ParameterizedTest
    @MethodSource("sourceInvalidSize")
    void test2(List<Integer> numbers) {
        assertThatThrownBy(() -> new BaseBalls(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("야구공은 3개만 허용됩니다.");
    }
}