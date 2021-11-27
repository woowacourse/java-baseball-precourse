package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {
    BaseballNums answerBaseballNums;
    BaseballNums playerBaseballNums;
    GameResult gameResult;

    @BeforeEach
    void 게임결과_테스트_기본세팅() {
        answerBaseballNums = new BaseballNums(Arrays.asList(4, 2, 3));
        playerBaseballNums = new BaseballNums(Arrays.asList(2, 4, 3));
        gameResult = new GameResult();
    }

    @Test
    void 스트라이크_볼_계산로직_검증() {
        // given // when
        gameResult.checkResult(answerBaseballNums, playerBaseballNums);

        // then
        assertAll(() -> {
            assertEquals(gameResult.getStrikeCount(), 1);
            assertEquals(gameResult.getBallCount(), 2);
        });
    }
}