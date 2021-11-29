package baseball.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class PlayerTest {
    private Player player;

    @BeforeEach
    void init() {
        player = new Player();
    }

    @Test
    @DisplayName("사용자로부터 숫자 입력받기 (정상)")
    void 숫자_입력받기() {
        assertThat(player.filtrate("123")).isInstanceOf(Integer.class);
    }

    @Test
    @DisplayName("사용자로부터 숫자 입력받기 : 숫자 외 문자 입력 예외")
    void 숫자_입력받기_예외1() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> player.filtrate("abc"));
    }

    @Test
    @DisplayName("사용자로부터 숫자 입력받기 : 3자리수가 아닌 예외")
    void 숫자_입력받기_예외2() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> player.filtrate("1234"));
    }

    @Test
    @DisplayName("사용자로부터 숫자 입력받기 : 중복되는 수 존재 예외")
    void 숫자_입력받기_예외3() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> player.filtrate("133"));
    }

    @Test
    @DisplayName("사용자로부터 숫자 입력받기 : 0 존재 예외")
    void 숫자_입력받기_예외4() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> player.filtrate("103"));
    }
}
