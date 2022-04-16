package baseball.game;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import baseball.DisplayedParameterizedTest;
import baseball.hitter.Hitter;
import baseball.pitcher.Pitcher;
import baseball.pitcher.PitchingResult;
import org.assertj.core.util.introspection.FieldSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

class BaseBallGameTest {

    @Test
    void 생성자_테스트() {
        BaseBallGame game = new BaseBallGame();

        Hitter hitter = FieldSupport.extraction().fieldValue("hitter", Hitter.class, game);
        assertThat(hitter).isNotNull();
    }

    @Test
    void 테스트용_생성자_테스트() {
        Hitter inputHitter = mock(Hitter.class);
        BaseBallGame game = new BaseBallGame(inputHitter);

        Hitter hitter = FieldSupport.extraction().fieldValue("hitter", Hitter.class, game);
        assertThat(hitter).isEqualTo(hitter);
    }

    @Test
    void 재시작_테스트() {
        Hitter oldHitter = new Hitter(asList(1, 2, 3));
        BaseBallGame game = new BaseBallGame(oldHitter);
        game.mount(new Pitcher("123"));

        game.restart();

        Hitter newHitter = FieldSupport.extraction().fieldValue("hitter", Hitter.class, game);
        assertThat(oldHitter).isNotEqualTo(newHitter);
        assertThat(game.isGameEnd()).isFalse();
    }

    @Test
    void 플레이_테스트() {
        Hitter hitter = mock(Hitter.class);
        Pitcher pitcher = mock(Pitcher.class);
        PitchingResult pitchingResult = mock(PitchingResult.class);
        BaseBallGame game = new BaseBallGame(hitter);

        when(pitcher.play(hitter)).thenReturn(pitchingResult);

        PitchingResult result = game.mount(pitcher);

        assertThat(result).isEqualTo(pitchingResult);
        assertThat(game.getLastPitchingResult()).isEqualTo(pitchingResult);
    }

    @Test
    void 플레이_테스트_null() {
        BaseBallGame game = new BaseBallGame();

        assertThatThrownBy(() -> game.mount((Pitcher) null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("pitcher 가 null 입니다");
    }

    @DisplayedParameterizedTest
    @CsvSource({"true", "false"})
    void 게임_종료_테스트(boolean isSuccess) {
        Hitter hitter = mock(Hitter.class);
        Pitcher pitcher = mock(Pitcher.class);
        PitchingResult pitchingResult = mock(PitchingResult.class);
        BaseBallGame game = new BaseBallGame(hitter);

        when(pitcher.play(hitter)).thenReturn(pitchingResult);
        when(pitchingResult.isSuccess()).thenReturn(isSuccess);

        game.mount(pitcher);

        assertThat(game.isGameEnd()).isEqualTo(isSuccess);
    }

    @Test
    void 문자열로_플레이_테스트() {
        Hitter hitter = new Hitter(asList(1, 2, 3));
        BaseBallGame baseBallGame = spy(new BaseBallGame(hitter));

        PitchingResult result = baseBallGame.mount("123");

        assertThat(result.isSuccess()).isTrue();
    }

    @Test
    void 문자열로_플레이_테스트_null() {
        BaseBallGame baseBallGame = new BaseBallGame(new Hitter());

        assertThatThrownBy(() -> baseBallGame.mount((String) null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 null 입니다");
    }

    @Test
    void 게임이_끝난_경우에_플레이_예외() {
        Hitter hitter = new Hitter(asList(1, 2, 3));
        BaseBallGame baseBallGame = spy(new BaseBallGame(hitter));
        baseBallGame.mount("123");

        assertThatThrownBy(() -> baseBallGame.mount("123"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("게임이 이미 종료되었습니다");
    }
}