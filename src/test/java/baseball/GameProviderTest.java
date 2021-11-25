package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class GameProviderTest {

    private GameProvider gameProvider;

    @BeforeEach
    void setUp(){
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(),anyInt())).thenReturn(1,2,3);
            gameProvider = new GameProvider();
        }

    }

    @DisplayName("정답 확인_3스트라이크")
    @Test
    void checkAnswer_ThreeStrike(){
        GameScore gameScore = gameProvider.checkAnswer(new int[]{1, 2, 3});
        assertThat(gameScore.getStrike()).isEqualTo(3);
        assertThat(gameScore.getBall()).isEqualTo(0);
    }

    @DisplayName("정답 확인_1볼_1스트라이크")
    @Test
    void checkAnswer_OneBall_OneStrike(){
        GameScore gameScore = gameProvider.checkAnswer(new int[]{1, 4, 2});
        assertThat(gameScore.getStrike()).isEqualTo(1);
        assertThat(gameScore.getBall()).isEqualTo(1);
    }

    @DisplayName("정답 확인_3볼")
    @Test
    void checkAnswer_ThreeBall(){
        GameScore gameScore = gameProvider.checkAnswer(new int[]{3, 1, 2});
        assertThat(gameScore.getStrike()).isEqualTo(0);
        assertThat(gameScore.getBall()).isEqualTo(3);
    }

    @DisplayName("정답 확인_낫싱")
    @Test
    void checkAnswer_Nothing(){
        GameScore gameScore = gameProvider.checkAnswer(new int[]{4, 5, 6});
        assertThat(gameScore.getStrike()).isEqualTo(0);
        assertThat(gameScore.getBall()).isEqualTo(0);
    }


}