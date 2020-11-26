package baseball.game;

import baseball.domain.BaseballType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameRuleTest {

    private BaseballGameRule baseballGameRule;

    @BeforeEach
    void beforeRunAllTest() {
        this.baseballGameRule = new BaseballGameRule();
    }

    @Test
    void baseballGame0Strike0Ball() {
        // givn
        int ballCount = 0;
        int strikeCount = 0;
        List<Integer> playerBaseballList = new ArrayList<>();
        playerBaseballList.add(5);
        playerBaseballList.add(6);
        playerBaseballList.add(7);

        List<Integer> randomBaseballList = new ArrayList<>();
        randomBaseballList.add(1);
        randomBaseballList.add(2);
        randomBaseballList.add(3);
        Set<Integer> randomBaseballSet = new HashSet<>(randomBaseballList);

        // when
        BaseballResult baseballResult = this.baseballGameRule.guessRandomAndPlayerBaseball(playerBaseballList,
                randomBaseballList, randomBaseballSet);

        // then
        assertThat(baseballResult.getBaseballTypeFrequency(BaseballType.BALL) == ballCount).isTrue();
        assertThat(baseballResult.getBaseballTypeFrequency(BaseballType.STRIKE) == strikeCount).isTrue();
    }

    @Test
    void baseballGame1Strike0Ball() {
        // givn
        int ballCount = 0;
        int strikeCount = 1;
        List<Integer> playerBaseballList = new ArrayList<>();
        playerBaseballList.add(1);
        playerBaseballList.add(6);
        playerBaseballList.add(7);

        List<Integer> randomBaseballList = new ArrayList<>();
        randomBaseballList.add(1);
        randomBaseballList.add(2);
        randomBaseballList.add(3);
        Set<Integer> randomBaseballSet = new HashSet<>(randomBaseballList);

        // when
        BaseballResult baseballResult = this.baseballGameRule.guessRandomAndPlayerBaseball(playerBaseballList,
                randomBaseballList, randomBaseballSet);

        // then
        assertThat(baseballResult.getBaseballTypeFrequency(BaseballType.BALL) == ballCount).isTrue();
        assertThat(baseballResult.getBaseballTypeFrequency(BaseballType.STRIKE) == strikeCount).isTrue();
    }

    @Test
    void baseballGame3Strike0Ball() {
        // givn
        int ballCount = 0;
        int strikeCount = 3;
        List<Integer> playerBaseballList = new ArrayList<>();
        playerBaseballList.add(1);
        playerBaseballList.add(2);
        playerBaseballList.add(3);

        List<Integer> randomBaseballList = new ArrayList<>();
        randomBaseballList.add(1);
        randomBaseballList.add(2);
        randomBaseballList.add(3);
        Set<Integer> randomBaseballSet = new HashSet<>(randomBaseballList);

        // when
        BaseballResult baseballResult = this.baseballGameRule.guessRandomAndPlayerBaseball(playerBaseballList,
                randomBaseballList, randomBaseballSet);

        // then
        assertThat(baseballResult.getBaseballTypeFrequency(BaseballType.BALL) == ballCount).isTrue();
        assertThat(baseballResult.getBaseballTypeFrequency(BaseballType.STRIKE) == strikeCount).isTrue();
    }


    @Test
    void baseballGame0Strike2Ball() {
        // givn
        int ballCount = 2;
        int strikeCount = 0;
        List<Integer> playerBaseballList = new ArrayList<>();
        playerBaseballList.add(3);
        playerBaseballList.add(5);
        playerBaseballList.add(2);

        List<Integer> randomBaseballList = new ArrayList<>();
        randomBaseballList.add(1);
        randomBaseballList.add(2);
        randomBaseballList.add(3);
        Set<Integer> randomBaseballSet = new HashSet<>(randomBaseballList);

        // when
        BaseballResult baseballResult = this.baseballGameRule.guessRandomAndPlayerBaseball(playerBaseballList,
                randomBaseballList, randomBaseballSet);

        // then
        assertThat(baseballResult.getBaseballTypeFrequency(BaseballType.BALL) == ballCount).isTrue();
        assertThat(baseballResult.getBaseballTypeFrequency(BaseballType.STRIKE) == strikeCount).isTrue();
    }

    @Test
    void baseballGame0Strike3Ball() {
        // givn
        int ballCount = 3;
        int strikeCount = 0;
        List<Integer> playerBaseballList = new ArrayList<>();
        playerBaseballList.add(3);
        playerBaseballList.add(1);
        playerBaseballList.add(2);

        List<Integer> randomBaseballList = new ArrayList<>();
        randomBaseballList.add(1);
        randomBaseballList.add(2);
        randomBaseballList.add(3);
        Set<Integer> randomBaseballSet = new HashSet<>(randomBaseballList);

        // when
        BaseballResult baseballResult = this.baseballGameRule.guessRandomAndPlayerBaseball(playerBaseballList,
                randomBaseballList, randomBaseballSet);

        // then
        assertThat(baseballResult.getBaseballTypeFrequency(BaseballType.BALL) == ballCount).isTrue();
        assertThat(baseballResult.getBaseballTypeFrequency(BaseballType.STRIKE) == strikeCount).isTrue();
    }

    @Test
    void baseballGame1Strike1Ball() {
        // givn
        int ballCount = 1;
        int strikeCount = 1;
        List<Integer> playerBaseballList = new ArrayList<>();
        playerBaseballList.add(1);
        playerBaseballList.add(4);
        playerBaseballList.add(2);

        List<Integer> randomBaseballList = new ArrayList<>();
        randomBaseballList.add(1);
        randomBaseballList.add(2);
        randomBaseballList.add(3);
        Set<Integer> randomBaseballSet = new HashSet<>(randomBaseballList);

        // when
        BaseballResult baseballResult = this.baseballGameRule.guessRandomAndPlayerBaseball(playerBaseballList,
                randomBaseballList, randomBaseballSet);

        // then
        assertThat(baseballResult.getBaseballTypeFrequency(BaseballType.BALL) == ballCount).isTrue();
        assertThat(baseballResult.getBaseballTypeFrequency(BaseballType.STRIKE) == strikeCount).isTrue();
    }
}