package baseball.pitcher;

import static baseball.hitter.HittingResult.BALL;
import static baseball.hitter.HittingResult.NOTHING;
import static baseball.hitter.HittingResult.STRIKE;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.DisplayedParameterizedTest;
import baseball.hitter.HittingResult;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PitchingResultTest {

    @Test
    void 생성자_테스트() {
        PitchingResult result = new PitchingResult();

        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.isPitchingEnd()).isFalse();
    }

    @DisplayedParameterizedTest
    @MethodSource("스트라이크_볼_추가_테스트")
    void 스트라이크_볼_추가_테스트(boolean isSuccess, int strike, int ball, List<HittingResult> hittingList) {
        PitchingResult result = new PitchingResult();

        for (HittingResult hitting : hittingList) {
            result.add(hitting);
        }

        assertThat(result.getBallCount()).isEqualTo(ball);
        assertThat(result.getStrikeCount()).isEqualTo(strike);
        assertThat(result.isSuccess()).isEqualTo(isSuccess);
    }

    static List<Arguments> 스트라이크_볼_추가_테스트() {
        return asList(
                Arguments.of(false, 1, 1, asList(STRIKE, NOTHING, BALL)),
                Arguments.of(false, 0, 3, asList(BALL, BALL, BALL)),
                Arguments.of(false, 2, 1, asList(STRIKE, BALL, STRIKE)),
                Arguments.of(false, 1, 2, asList(BALL, BALL, STRIKE)),
                Arguments.of(true, 3, 0, asList(STRIKE, STRIKE, STRIKE))
        );
    }

    @DisplayedParameterizedTest
    @MethodSource("게임_종료와_Nothing_테스트")
    void 게임_종료와_Nothing_테스트(boolean isPitchingEnd, boolean isNothing, List<HittingResult> hittingList) {
        PitchingResult result = new PitchingResult();

        for (HittingResult hitting : hittingList) {
            result.add(hitting);
        }

        assertThat(result.isPitchingEnd()).isEqualTo(isPitchingEnd);
        assertThat(result.isNothing()).isEqualTo(isNothing);
    }

    static List<Arguments> 게임_종료와_Nothing_테스트() {
        return asList(
                Arguments.of(true, true, asList(NOTHING, NOTHING, NOTHING)),
                Arguments.of(false, true, asList(NOTHING, NOTHING)),
                Arguments.of(true, false, asList(NOTHING, NOTHING, STRIKE)),
                Arguments.of(false, false, asList(NOTHING, STRIKE))
        );
    }

    @DisplayedParameterizedTest
    @MethodSource("게임_종료와_Nothing_테스트")
    void 결과_추가_예외_테스트() {
        PitchingResult result = new PitchingResult();
        result.add(NOTHING);
        result.add(NOTHING);
        result.add(NOTHING);
        assertThatThrownBy(() -> result.add(NOTHING))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 결과는 최대 3 번 만 실행할 수 있습니다");
    }

    @Test
    void 결과_추가_null() {
        PitchingResult result = new PitchingResult();
        assertThatThrownBy(() -> result.add(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("HittingResult 가 null 입니다");
    }

}