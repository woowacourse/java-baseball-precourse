package com.nekisse.baseball;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTurnResultTest {

    @Test
    public void 스트라이크_3개이면_게임종료() {
        GameTurnResult treeStrike = new GameTurnResult(3,0);
        GameTurnResult twoStrikeOneBall= new GameTurnResult(2,1);

        assertThat(treeStrike.isEnd()).isTrue();
        assertThat(twoStrikeOneBall.isEnd()).isFalse();

    }
}