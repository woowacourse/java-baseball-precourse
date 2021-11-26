package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.domain.vo.number.Number;
import baseball.domain.vo.number.UniqueNumberFactory;

class UniqueNumberFactoryTest {

    @Test
    void 중복_없는_숫자를_생성할_수_있다() {
        for (int i = 0; i < 100; i++) {
            Number uniqueNumber = UniqueNumberFactory.create();
            boolean actual = uniqueNumber.isUnique();
            assertTrue(actual);
        }
    }

}