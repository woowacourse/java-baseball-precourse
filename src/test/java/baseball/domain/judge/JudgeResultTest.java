package baseball.domain.judge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayName("판정 기록기에 대한 테스트")
class JudgeResultTest {

    private JudgeResult judgeResult;

    @BeforeEach
    void setUp() {
        judgeResult = JudgeResult.empty();
    }

    @DisplayName("특정 판정에 대한 카운트를 가져온다.")
    @ParameterizedTest
    @EnumSource(Judgement.class)
    void get(final Judgement judgement) {
        final int expect = 0;

        final int count = judgeResult.get(judgement);

        assertEquals(count, expect);
    }

    @DisplayName("특정 판정에 대한 카운트를 1개 증가시킨다.")
    @ParameterizedTest
    @EnumSource(Judgement.class)
    void increment(final Judgement judgement) {
        final int expect = 1;

        judgeResult.increment(judgement);

        assertEquals(judgeResult.get(judgement), expect);
    }
}