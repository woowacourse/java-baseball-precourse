package com.nekisse.baseball;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    @Test
    public void 같은자리_숫자가_동일하면_스트라이크_증가() {
        Referee referee = new Referee(Arrays.asList(1, 2, 3));

        GameTurnResult result = referee.compareGameNumberResult(Arrays.asList(1, 4, 3));

        assertThat(result.getStrikeCount()).isEqualTo(2);

    }


    @Test
    public void 자리는_다르고_숫자가_존재한다면_볼_증가() {
        Referee referee = new Referee(Arrays.asList(1, 2, 3));

        GameTurnResult result = referee.compareGameNumberResult(Arrays.asList(1,3,2));

        assertThat(result.getBallCount()).isEqualTo(2);
    }

}
