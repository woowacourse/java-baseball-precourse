package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallGameTest {
    static final int NUMBER_COUNT = 3;

    @Test
    public void 같은자리_같은수_존재하면_스트라이크() throws Exception {
        //given
        List<Integer> computer = Arrays.asList(1,2,3);
        List<Integer> user = Arrays.asList(2,5,3);
        long strikeCount = 0;

        //when
        strikeCount = IntStream.range(0, NUMBER_COUNT)
                .filter(i -> computer.get(i).equals(user.get(i)))
                .count();

        //then
        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    public void 다른자리_같은수_존재하면_볼() throws Exception {
        //given
        List<Integer> computer = Arrays.asList(1,2,3);
        List<Integer> user = Arrays.asList(4,3,5);
        long ballCount = 0;

        //when
        ballCount = IntStream.range(0, NUMBER_COUNT)
                .filter(i -> (computer.get(i) != user.get(i)) && computer.contains(user.get(i)))
                .count();

        //then
        assertThat(ballCount).isEqualTo(1);
    }
}