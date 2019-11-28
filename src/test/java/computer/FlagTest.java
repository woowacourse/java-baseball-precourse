package computer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FlagTest {

    @DisplayName("게임 진행 플래그 생성")
    @Test
    void init() {
        Flag flag = Flag.init();

        assertThat(flag).isEqualTo(new Flag(1));
    }

    @DisplayName("게임 진행 가능 확인")
    @Test
    void isRunnable() {
        Flag flag = Flag.init();

        assertThat(flag.isRunnable()).isTrue();

        flag = new Flag(2);

        assertThat(flag.isRunnable()).isFalse();
    }
}