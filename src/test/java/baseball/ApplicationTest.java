package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

//  - [예외] 입력한 문자가 숫자인지 검사
//  - 사용자 입력을 3개의 숫자 리스트로 변환

    @DisplayName("입력한 길이가 3인지 검사")
    @Test
    void string_length_is_3() {
        Application application = new Application();
        application.validateLength("123");
        assertThatThrownBy(() -> application.validateLength("1234"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 문자열이 숫자인지 검사")
    @Test
    void stringIsNumber() {
        Application application = new Application();
        application.validateNumbers("123");
        assertThatThrownBy(() -> application.validateNumbers("a23"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자가 숫자인지 검사")
    @Test
    void charIsNumber() {
        Application application = new Application();
        application.validateNumber('1');
        assertThatThrownBy(() -> application.validateNumber('a'))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열을 숫자 리스트로 변환")
    @Test
    void convertStringToNumberList() {
        Application application = new Application();
        assertThat(
            application.convertStringToNumberList("123")
            .containsAll(Arrays.asList(1, 2, 3))
        ).isTrue();
    }
}
