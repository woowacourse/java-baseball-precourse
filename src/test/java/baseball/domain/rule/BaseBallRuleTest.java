package baseball.domain.rule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallRuleTest {

    private BaseBallRule baseBallRule;
    List<Integer> computerNumbers;
    List<Integer> userNumbers;

    @BeforeEach
    void setUp() {

        //given // when
        baseBallRule = new BaseBallRule();

    }

    @Test
    @DisplayName("매치되는 카운트가 갖은지 확인한다.")
    void 매칭_갯수_테스트() {

        // given
        computerNumbers = Arrays.asList(1, 2, 3);
        userNumbers = Arrays.asList(1, 2, 3);

        // when
        int matchedCount = baseBallRule.correctCount(computerNumbers, userNumbers);

        // then
        assertThat(matchedCount).isEqualTo(3);
    }

    @Test
    @DisplayName("매치되는 위치가 같은지 테스트한다.")
    void 매칭_위치_테스트() {
        // given
        computerNumbers = Arrays.asList(8, 2, 9);

        // when // then
        assertThat(baseBallRule.equalPostion(computerNumbers, 0, 8)).isTrue();
        assertThat(baseBallRule.equalPostion(computerNumbers, 1, 2)).isTrue();
        assertThat(baseBallRule.equalPostion(computerNumbers, 2, 9)).isTrue();
    }
}