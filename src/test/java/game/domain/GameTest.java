
/*
 * GameTest.java
 * @author crystal_rim
 * @version 1.0.0
 * @date 2019-12-02
 */
package game.domain;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private final String answerNumbers = "123";

    public MatchResult 매칭테스트(String inputText) throws Exception {
        // given
        Numbers inputNumbers = Numbers.valueOf(inputText);
        FixedNumbersGenerator numbersGenerator = new FixedNumbersGenerator(answerNumbers);
        Game game = new Game(numbersGenerator);
        // when
        return game.match(inputNumbers);
    }

    @Test
    public void 같은수가없음_낫싱() throws Exception {
        MatchResult result = 매칭테스트("456");
        // then
        assertThat(result.isExistBall()).isFalse();
        assertThat(result.isExistStrike()).isFalse();
    }

    @Test
    public void 스트라이크3() throws Exception {
        MatchResult result = 매칭테스트("123");
        // then
        assertThat(result.getStrikeCount()).isEqualTo(3);
    }

    @Test
    public void 볼2() throws Exception {
        MatchResult result = 매칭테스트("351");
        // then
        assertThat(result.getBallCount()).isEqualTo(2);
    }

    @Test
    public void 스트라이크1_볼1() throws Exception {
        MatchResult result = 매칭테스트("136");
        // then
        assertThat(result.getBallCount()).isEqualTo(1);
        assertThat(result.getStrikeCount()).isEqualTo(1);
    }
}
