package baseball.hint;

import baseball.game.Game;
import baseball.pitch.Pitch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class HintTest {
    private Game game;
    private Set<Pitch> computerSet;
    private Set<Pitch> playerSet;
    private int strike;
    private int ball;

    @BeforeEach
    void init() {
        computerSet = game.getPitchSet(123);
        playerSet = game.getPitchSet(132);
        game = new Game();
        strike = 0;
        ball = 0;
    }

    @Test
    @DisplayName("컴퓨터값과 사용자값을 비교하여 저장")
    void 비교하여_저장() {
        // "123" 과 "132" 는 1볼 1스트라이크
        Hint result = new Hint(computerSet, playerSet);
        Hint compare = new Hint(1,2);
        assertThat(result.isSame(compare)).isTrue();
    }
}
