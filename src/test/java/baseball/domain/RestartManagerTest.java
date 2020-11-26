package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RestartManagerTest {

    @DisplayName("재시작 요청을 입력했을 때, 재시작할 수 있는지를 알려주는 기능을 테스트한다 ")
    @Test
    void testInitRestartManagerIfInputRestartRequest() {
        //given
        String restartRequest = "1";

        //when
        RestartManager restartManager = new RestartManager(restartRequest);

        //then
        assertThat(restartManager.canRestart()).isTrue();
    }

    @DisplayName("종료 요청을 입력했을 때, 재시작할 수 있는지를 알려주는 기능을 테스트한다 ")
    @Test
    void testInitRestartManagerIfInputStopRequest() {
        //given
        String stopRequest = "2";

        //when
        RestartManager restartManager = new RestartManager(stopRequest);

        //then
        assertThat(restartManager.canRestart()).isFalse();
    }

    @DisplayName("정의되지 않은 요청을 입력했을 때, 숫자야구게임을 재시작하는 기능은 예외를 발생한다 ")
    @ParameterizedTest
    @ValueSource(strings = {"0", "3", "$", "a"})
    void testRestartFunctionIfInputUndefinedRequest(String wrongRequest) {
        //when //then
        assertThatThrownBy(() -> new RestartManager(wrongRequest))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
