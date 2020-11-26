package baseball;

import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.FixedNumbersGenerator;
import baseball.domain.Pitcher;

public class PitcherTest {

    @Test
    @DisplayName("인덱스에 해당하는 숫자 반환 테스트")
    public void getNumberTest() {
        String numbers = "123";
        int numberIndex = 1;
        Pitcher pitcher = new Pitcher(new FixedNumbersGenerator(new Scanner(System.in)) {
            @Override
            public String generateNumbers() {
                return numbers;
            }
        });

        pitcher.receiveBalls();

        assertThat(pitcher.pitch(numberIndex)).isEqualTo(numbers.charAt(numberIndex)-'0');
    }
}
