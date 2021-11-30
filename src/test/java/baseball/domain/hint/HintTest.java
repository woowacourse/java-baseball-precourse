package baseball.domain.hint;

import baseball.domain.game.Game;
import baseball.domain.pitch.Pitch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class HintTest {
    private Game game = new Game();
    private Set<Pitch> computerSet;
    private Set<Pitch> playerSet;
    private int strike;
    private int ball;

    @BeforeEach
    void init() {
        List<Integer> computerNum = Arrays.asList(1, 2, 3);
        List<Integer> playerNum = Arrays.asList(1, 3, 2);
        computerSet = game.getPitchSet(computerNum);
        playerSet = game.getPitchSet(playerNum);
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
