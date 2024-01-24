package baseball.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RefereeTest {

    @MethodSource("numbersAndCounts")
    @ParameterizedTest
    void 두_Number를_비교해서_Result를_반환한다(Number answer, Number number, int ballCount, int strikeCount) {
        // given, when
        Result result = Referee.call(answer, number);

        // then
        assertSoftly(softly -> {
                    assertThat(result.fetchBallCount()).isEqualTo(ballCount);
                    assertThat(result.fetchStrikeCount()).isEqualTo(strikeCount);
                }
        );

    }

    private static Stream<Arguments> numbersAndCounts() {
        return Stream.of(
                Arguments.arguments(new Number(123), new Number(456), 0, 0),
                Arguments.arguments(new Number(123), new Number(356), 1, 0),
                Arguments.arguments(new Number(123), new Number(324), 1, 1),
                Arguments.arguments(new Number(123), new Number(123), 0, 3)
        );
    }
}