package baseball;

//  - [ ] 2개의 Balls를 비교해 Map 자료구조로 STRIKE, BALL, NOTHING의 몇개인지 저장
//      - [ ] Ball과 위치값을 받아 STRIKE, BALL, NOTHING 인지 비교하여 맞는 타입 반환
//      - [ ] Map 자료구조를 반환
//      - [ ] STRIKE, BALL, NOTHING 의 개수를 각각 반환

import static baseball.BallType.BALL;
import static baseball.BallType.NOTHING;
import static baseball.BallType.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HintTest {

    @DisplayName("Ball, 위치 값을 받아 볼의 상태 반환")
    @Test
    void getType() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Hint hint = new Hint(balls);
        assertThat(hint.getType(new Ball(1), 0)).isEqualTo(STRIKE);
        assertThat(hint.getType(new Ball(1), 1)).isEqualTo(BALL);
        assertThat(hint.getType(new Ball(4), 0)).isEqualTo(NOTHING);
    }
}
