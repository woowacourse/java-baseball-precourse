package baseball;

import static baseball.StringUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomNumberFactoryTest {
    private Set<Integer> numbers;

    @BeforeEach
    void 난수_생성() {
        numbers = RandomNumberFactory.generate();
    }

    @Test
    void 생성된_난수는_3자리() {
        assertThat(numbers).hasSize(NUMBER_OF_DIGITS_OF_GAME_NUMBER);
    }

    @Test
    void 난수는_1_에서_9의_수로_구성2() {
        assertThat(numbers).allSatisfy(integer -> assertAll(
                () -> assertThat(integer).isGreaterThanOrEqualTo(MIN_GAME_NUMBER),
                () -> assertThat(integer).isLessThanOrEqualTo(MAX_GAME_NUMBER))
        );
    }

    @Test
    void 생성된_난수는_서로_다른_수로_구성() {
        for (int number : numbers) {
            assertThat(numbers).containsOnlyOnce(number);
        }
    }
}
