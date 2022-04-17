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
        int matchedCount = baseBallRule.matchedCount(computerNumbers, userNumbers);

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

    @Test
    @DisplayName("낫띵 테스트")
    void 낫띵_테스트() {

        // given
        computerNumbers = Arrays.asList(1, 2, 3);
        userNumbers = Arrays.asList(4, 5, 6);

        // when
        baseBallRule.compareBall(computerNumbers, userNumbers);

        // then
        assertThat(baseBallRule.getStrikeCount()).isEqualTo(0);
        assertThat(baseBallRule.getBallCount()).isEqualTo(0);

    }

    @Test
    @DisplayName("1볼 테스트")
    void 원볼_테스트() {

        // given
        computerNumbers = Arrays.asList(1, 2, 3);
        userNumbers = Arrays.asList(4, 5, 1);

        // when
        baseBallRule.compareBall(computerNumbers, userNumbers);

        // then
        assertThat(baseBallRule.getStrikeCount()).isEqualTo(0);
        assertThat(baseBallRule.getBallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("2볼 테스트")
    void 투볼_테스트() {

        // given
        computerNumbers = Arrays.asList(1, 2, 3);
        userNumbers = Arrays.asList(4, 3, 1);

        // when
        baseBallRule.compareBall(computerNumbers, userNumbers);

        // then
        assertThat(baseBallRule.getStrikeCount()).isEqualTo(0);
        assertThat(baseBallRule.getBallCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("3볼 테스트")
    void 쓰리볼_테스트() {

        // given
        computerNumbers = Arrays.asList(1, 2, 3);
        userNumbers = Arrays.asList(2, 3, 1);

        // when
        baseBallRule.compareBall(computerNumbers, userNumbers);

        // then
        assertThat(baseBallRule.getStrikeCount()).isEqualTo(0);
        assertThat(baseBallRule.getBallCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("1스트라이크 테스트")
    void 원스트라이크_테스트() {

        // given
        computerNumbers = Arrays.asList(1, 2, 3);
        userNumbers = Arrays.asList(1, 5, 7);

        // when
        baseBallRule.compareBall(computerNumbers, userNumbers);

        // then
        assertThat(baseBallRule.getStrikeCount()).isEqualTo(1);
        assertThat(baseBallRule.getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("2스트라이크 테스트")
    void 투스트라이크_테스트() {

        // given
        computerNumbers = Arrays.asList(1, 2, 3);
        userNumbers = Arrays.asList(1, 2, 7);

        // when
        baseBallRule.compareBall(computerNumbers, userNumbers);

        // then
        assertThat(baseBallRule.getStrikeCount()).isEqualTo(2);
        assertThat(baseBallRule.getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("3스트라이크 테스트")
    void 쓰리스트라이크_테스트() {

        // given
        computerNumbers = Arrays.asList(1, 2, 3);
        userNumbers = Arrays.asList(1, 2, 3);

        // when
        baseBallRule.compareBall(computerNumbers, userNumbers);

        // then
        assertThat(baseBallRule.getStrikeCount()).isEqualTo(3);
        assertThat(baseBallRule.getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("1볼 1스트라이크 테스트")
    void 원볼_원스트라이크_테스트() {

        // given
        computerNumbers = Arrays.asList(1, 2, 3);
        userNumbers = Arrays.asList(1, 5, 2);

        // when
        baseBallRule.compareBall(computerNumbers, userNumbers);

        // then
        assertThat(baseBallRule.getStrikeCount()).isEqualTo(1);
        assertThat(baseBallRule.getBallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("1볼 2스트라이크는 불가능하다")
    void 원볼_투스트라이크는_게임상_존재할_수_없다() {

        // given
        computerNumbers = Arrays.asList(1, 2, 3);
        userNumbers = Arrays.asList(1, 5, 3);

        // when
        baseBallRule.compareBall(computerNumbers, userNumbers);

        // then
        assertThat(baseBallRule.getStrikeCount()).isEqualTo(2);
        assertThat(baseBallRule.getBallCount()).isNotEqualTo(1);
    }

    @Test
    @DisplayName("2볼 1스트라이크 테스트")
    void 투볼_원스트라이크_테스트() {

        // given
        computerNumbers = Arrays.asList(1, 2, 3);
        userNumbers = Arrays.asList(2, 1, 3);

        // when
        baseBallRule.compareBall(computerNumbers, userNumbers);

        // then
        assertThat(baseBallRule.getStrikeCount()).isEqualTo(1);
        assertThat(baseBallRule.getBallCount()).isEqualTo(2);
    }
}