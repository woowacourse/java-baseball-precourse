package baseball.game;

import baseball.pitch.Pitch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {
    private Game game;

    @BeforeEach
    void init() {
        game = new Game();
    }

    @Test
    @DisplayName("입력한 수를 Pitch 집합으로 변환")
    void 입력한_수의_Pitch_추출() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Set<Pitch> pitchSet = game.getPitchSet(list);
        int size = pitchSet.size();
        // 정상적으로
        assertThat(size).isEqualTo(3);
    }
}
