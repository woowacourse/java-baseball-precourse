package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballNumsGeneratorTest {

    @Test
    public void 랜덤한_3자리_숫자_생성() {
        // given // when
        BaseballNums randomBaseballNums = BaseballNumsGenerator.generateRandomBaseballNums();

        // then
        assertEquals(3, randomBaseballNums.getBaseballNums().size());
    }
}