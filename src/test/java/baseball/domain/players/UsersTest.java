package baseball.domain.players;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UsersTest {

    private Users users;

    @BeforeEach
    void setUp() {

        users = new Users();

    }

    @Test
    @DisplayName("split 테스트")
    void split_메소드_테스트() {

        // given, when
        String[] numbers = "123".split("");

        // then
        assertThat(numbers.length).isEqualTo(3);
        assertThat(numbers).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("유저가 2자리를 입력하면 안된다.")
    void 유저가_두자리_숫자만_입력한다() {

        // given
        String input = "12";

        //then
        assertThatThrownBy(() -> users.isValidNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유저는 정상적인 숫자를 입력한다")
    @ParameterizedTest
    @ValueSource(strings = {"123", "165", "139", "912", "928"})
    void 유저가_입력한_숫자가_유효한가(String input) {

        // when
        boolean isValidNumber = users.isValidNumber(input);

        //then
        assertThat(isValidNumber).isTrue();
    }

    @DisplayName("유저는 비정상적인 숫자를 입력한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1ab", "b65", "cnd", "ape", "92n", "a2b"})
    void 유저가_입력한_숫자가_유효하지않다(String input) {

        //when, then
        assertThatThrownBy(() -> users.isValidNumber(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("0이 들어가면 안된다.")
    @ParameterizedTest
    @ValueSource(strings = {"031", "103", "310"})
    void 영이_들어가도_유효하지않다(String input) {

        //when, then
        assertThatThrownBy(() -> users.isValidNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}