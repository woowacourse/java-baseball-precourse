package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BaseBallGameTest {

    @DisplayName("최초 생성시 게임 진행 가능")
    @Test
    void runnable() {
        BaseBallGame baseBallGame = BaseBallGame.init();

        assertThat(baseBallGame.runnable()).isTrue();
    }
}