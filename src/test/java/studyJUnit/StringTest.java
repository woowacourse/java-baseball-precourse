package studyJUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("요구사항 1 split테스트")
    void 스플릿_테스트() {

        // given, when
        String[] splitOneTwo = "1,2".split(",");

        // then
        assertThat(splitOneTwo).contains("1", "2");
        assertThat(splitOneTwo).containsExactly("1", "2");
        assertThat(splitOneTwo).hasSize(2);

        // given, when
        String[] splitOne = "1".split(",");

        // then
        assertThat(splitOne).contains("1");
        assertThat(splitOne).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2 substring 테스트")
    void 서브스트링_테스트() {

        // given
        String input = "(1,2)";

        // when
        String result = input.substring(1, 4);

        // then
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("요구사항 3 charAt 테스트")
    void 캐릭터앳_테스트() {

        //given
        String input = "abc";

        //when
        char result = input.charAt(0);

        //then
        assertThat(result).isEqualTo('a');

        //then
        assertThatThrownBy(() -> input.charAt(100))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 100");
    }
}
