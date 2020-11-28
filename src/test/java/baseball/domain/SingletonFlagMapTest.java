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
        final int nonExistingFlag = -1;

        // then
        assertThrows(IllegalArgumentException.class, () -> singletonFlagMap.getFlagFromNumber(nonExistingFlag));
    }

    @Test
    void getFlagFromNumberRestartTest() {
        // given
        SingletonFlagMap singletonFlagMap = SingletonFlagMap.getInstance();

        // when
        final int restartFlag = 1;

        // then
        assertEquals(singletonFlagMap.getFlagFromNumber(restartFlag), ExecutionFlagType.RESTART);
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