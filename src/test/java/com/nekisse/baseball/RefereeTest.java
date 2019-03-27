package com.nekisse.baseball;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    @Test
    public void 같은자리_숫자가_동일하면_스트라이크_증가() {
        BaseballNumbers gameNumbers = BaseballNumbers.of(1, 2, 3);
        BaseballNumbers userNumbers = BaseballNumbers.of(1, 4, 3);

        Referee referee = new Referee(gameNumbers);

        GameTurnResult result = referee.compareGameNumberResult(userNumbers);

        assertThat(result.getStrikeCount()).isEqualTo(2);

    }


    @Test
    public void 자리는_다르고_숫자가_존재한다면_볼_증가() {
        BaseballNumbers gameNumbers = BaseballNumbers.of(1, 2, 3);
        BaseballNumbers userNumbers = BaseballNumbers.of(1, 3, 2);

        Referee referee = new Referee(gameNumbers);

        GameTurnResult result = referee.compareGameNumberResult(userNumbers);

        assertThat(result.getBallCount()).isEqualTo(2);
    }

}
