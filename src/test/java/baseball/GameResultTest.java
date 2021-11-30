package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    void 스트라이크가_3개인지_확인() {
        int strike = 3;
        int ball = 0;
        GameResult gameResult = new GameResult(strike, ball);
        assertThat(gameResult.isThreeStrike()).isTrue();
    }

    @Test
    void 출력할_String_반환() {
        int strike = 1;
        int ball = 2;
        GameResult gameResult = new GameResult(strike, ball);
        assertThat(gameResult.toPrint()).isEqualTo("2볼 1스트라이크");
    }
}
