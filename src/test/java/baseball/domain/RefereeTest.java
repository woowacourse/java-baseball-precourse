package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.resource.GameRule;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RefereeTest {

    private static Referee referee = new Referee();

    @Test
    void 랜덤값생성_자릿수확인() {
        List<Integer> randomNumbers = makeRandomNumbers();

        assertThat(randomNumbers.size()).isEqualTo(GameRule.NUMBERS_DIGITS);
    }

    @Test
    void 랜덤값생성_중복포함확인() {
        List<Integer> randomNumbers = makeRandomNumbers();

        for (int i = 1; i < GameRule.NUMBERS_DIGITS; i++) {
            assertThat(randomNumbers.get(i-1)).isNotEqualTo(randomNumbers.get(i));
        }
    }

    @Test
    void 랜덤값생성_범위내숫자로구성되었는지_확인() {
        List<Integer> randomNumbers = makeRandomNumbers();

        for (int number : randomNumbers) {
            assertTrue(GameRule.NUMBER_GAME_PLAY <= number && number <= GameRule.NUMBERS_END_INCLUSION);
        }
    }


    private List<Integer> makeRandomNumbers() {
        referee.pickRandomNumbers();
        return referee.getTargetNumbers();
    }
}
