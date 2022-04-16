package baseball.hitter;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.RepeatedTest.LONG_DISPLAY_NAME;

import baseball.DisplayedParameterizedTest;
import java.util.List;
import org.assertj.core.util.introspection.FieldSupport;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class HitterTest {

    @RepeatedTest(value = 5, name = LONG_DISPLAY_NAME)
    void 랜덤_생성자_테스트() {
        new Hitter();
    }

    @DisplayedParameterizedTest
    @CsvSource({"1,2,3", "5,6,7"})
    void 내부_생성자_테스트(int first, int second, int third) {
        Hitter hitter = new Hitter(asList(first, second, third));

        List<Integer> hittingArr = FieldSupport.extraction().fieldValue("hittingList", List.class, hitter);
        assertThat(hittingArr)
                .containsExactly(first, second, third);
    }

    @DisplayedParameterizedTest
    @MethodSource("내부_생성자_실패_테스트")
    void 내부_생성자_예외_테스트(List<Integer> input, String desc) {
        assertThatThrownBy(() -> new Hitter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(desc);
    }

    static List<Arguments> 내부_생성자_실패_테스트() {
        return asList(
                Arguments.of(null, "hitting 은 null 입니다"),
                Arguments.of(asList(1, 1, 2), "각각의 hitting 은 서로 달라야합니다"),
                Arguments.of(asList(1, 2), "3개의 hitting 을 제시해야합니다"),
                Arguments.of(asList(1, 1, 2, 4), "3개의 hitting 을 제시해야합니다"),
                Arguments.of(asList(1, 2, 12), "hitting 은 0~9 사이의 수를 가질 수 있습니다"),
                Arguments.of(asList(1, -2, 3), "hitting 은 0~9 사이의 수를 가질 수 있습니다")
        );
    }

    @DisplayedParameterizedTest
    @CsvSource({
            "0, 1, STRIKE", "1, 1, BALL",
            "1, 2, STRIKE", "2, 2, BALL",
            "2, 3, STRIKE", "0, 3, BALL",
            "1, 4, NOTHING", "0, 6, NOTHING",
    })
    void 타격_테스트(int index, int pitching, HittingResult expect) {
        Hitter hitter = new Hitter(asList(1, 2, 3));

        HittingResult hittingResult = hitter.hit(index, pitching);
        assertThat(hittingResult).isEqualTo(expect);
    }

    @DisplayedParameterizedTest
    @CsvSource({
            "-1, 1, hit index 는 0~2 사이만 가능합니다",
            " 3, 1, hit index 는 0~2 사이만 가능합니다",
            "1, -1, pitching 은 0~9 사이의 수를 가질 수 있습니다",
            "2, 10, pitching 은 0~9 사이의 수를 가질 수 있습니다"
    })
    void 타격_예외_테스트(int index, int pitching) {
        Hitter hitter = new Hitter(asList(1, 2, 3));

        assertThatThrownBy(() -> hitter.hit(index, pitching))
                .isInstanceOf(IllegalArgumentException.class);
    }

}