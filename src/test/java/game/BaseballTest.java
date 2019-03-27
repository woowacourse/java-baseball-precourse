package game;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author delf
 */
public class BaseballTest {

    private Baseball baseball;

    @Before
    public void init() {
        this.baseball = new Baseball();
    }

    @Test
    public void 정답_숫자를_입력하고_정답_결과를_반환한다() {
        baseball.start(new int[]{4, 6, 1});
        OneSetResult result = baseball.playOneSetGame(new int[]{4, 6, 1});

        assertThat(result.isHit()).isTrue();

        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    public void 오답_숫자를_입력하고_오답_결과를_반환한다() {
        baseball.start(new int[]{4, 6, 1});
        OneSetResult result = baseball.playOneSetGame(new int[]{4, 6, 2});

        assertThat(result.isHit()).isFalse();

        assertThat(result.getStrike()).isEqualTo(2);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    public void 스트라이크를_정상적으로_처리한다() {
        baseball.start(new int[]{4, 6, 1});
        OneSetResult result = baseball.playOneSetGame(new int[]{2, 6, 7});

        assertThat(result.isHit()).isFalse();

        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    public void 볼을_정상적으로_처리한다() {
        baseball.start(new int[]{4, 6, 1});
        OneSetResult result = baseball.playOneSetGame(new int[]{1, 4, 6});

        System.out.println(result);
        assertThat(result.isHit()).isFalse();
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(3);
    }
}
