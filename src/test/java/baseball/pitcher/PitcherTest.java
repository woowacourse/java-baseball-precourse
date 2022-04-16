package baseball.pitcher;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.DisplayedParameterizedTest;
import baseball.hitter.Hitter;
import java.util.List;
import org.assertj.core.util.introspection.FieldSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class PitcherTest {

    @DisplayedParameterizedTest
    @CsvSource({"021,0,2,1", "567,5,6,7", })
    void 생성자_테스트(String input, int e1, int e2, int e3) {
        Pitcher pitcher = new Pitcher(input);

        List<Integer> pitchingList = FieldSupport.extraction().fieldValue("pitchingList", List.class, pitcher);

        assertThat(pitchingList)
                .containsExactly(e1, e2, e3);
    }

    @DisplayedParameterizedTest
    @CsvSource({
            ",     입력값이 null 입니다",
            "1234, 3가지 숫자만 입력할 수 있습니다",
            "12,   3가지 숫자만 입력할 수 있습니다",
            "12a , 숫자만 입력 가능합니다",
            "테st,  숫자만 입력 가능합니다",
            "111,  각각의 숫자는 서로 달라야합니다"
    })
    void 생성자_예외_테스트(String input, String desc) {
        assertThatThrownBy(() -> new Pitcher(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(desc);
    }

    @DisplayedParameterizedTest
    @MethodSource("플레이_테스트")
    void 플레이_테스트(List<Integer> hittingList, String pitchingStr, int strike, int ball, boolean isSuccess) {
        Hitter hitter = new Hitter(hittingList);
        Pitcher pitcher = new Pitcher(pitchingStr);

        PitchingResult result = pitcher.play(hitter);

        assertThat(result.getStrikeCount()).isEqualTo(strike);
        assertThat(result.getBallCount()).isEqualTo(ball);
        assertThat(result.isSuccess()).isEqualTo(isSuccess);
    }

    static List<Arguments> 플레이_테스트() {
        return asList(
                Arguments.of(asList(1, 2, 3), "123", 3, 0, true),
                Arguments.of(asList(1, 2, 3), "321", 1, 2, false),
                Arguments.of(asList(1, 2, 3), "312", 0, 3, false),
                Arguments.of(asList(0, 5, 9), "058", 2, 0, false),
                Arguments.of(asList(2, 7, 3), "098", 0, 0, false),
                Arguments.of(asList(1, 2, 5), "251", 0, 3, false)
        );
    }

    @Test
    void 플레이_테스트_null() {
        Pitcher pitcher = new Pitcher("123");

        assertThatThrownBy(() -> pitcher.play(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("hitter 가 null 입니다");
    }

}