package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SingletonFlagMapTest {

    @Test
    void getFlagFromNumberExceptionTest() {
        // given
        SingletonFlagMap singletonFlagMap = SingletonFlagMap.getInstance();

        // when
        final int NON_EXISTING_FLAG = -1;

        // then
        assertThrows(IllegalArgumentException.class, () -> singletonFlagMap.getFlagFromNumber(NON_EXISTING_FLAG));
    }

    @Test
    void getFlagFromNumberRestartTest() {
        // given
        SingletonFlagMap singletonFlagMap = SingletonFlagMap.getInstance();

        // when
        final int RESTART_FLAG = 1;

        // then
        assertEquals(singletonFlagMap.getFlagFromNumber(RESTART_FLAG), ExecutionFlagType.RESTART);
    }

    @Test
    void getFlagFromNumberStopTest() {
        // given
        SingletonFlagMap singletonFlagMap = SingletonFlagMap.getInstance();

        // when
        final int STOP_FLAG = 2;

        // then
        assertEquals(singletonFlagMap.getFlagFromNumber(STOP_FLAG), ExecutionFlagType.STOP);
    }
}