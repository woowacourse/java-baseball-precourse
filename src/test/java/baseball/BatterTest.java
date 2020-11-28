package baseball;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Batter;
import baseball.domain.FixedNumbersGenerator;
import baseball.domain.Judgment;

public class BatterTest {

    private final String answerNumbers = "123";

    private Batter batter;

    @BeforeEach
    public void initBatter() {
        batter = new Batter(new FixedNumbersGenerator(answerNumbers));
    }

    @Test
    @DisplayName("스트라이크 반환 테스트")
    public void returnStrikeTest() {
        assertThat(batter.swing(1, 2)).isEqualTo(Judgment.STRIKE);
    }

    @Test
    @DisplayName("볼 반환 테스트")
    public void returnBallTest() {
        assertThat(batter.swing(0, 2)).isEqualTo(Judgment.BALL);
    }

    @Test
    @DisplayName("볼 반환 테스트")
    public void returnNothingTest() {
        assertThat(batter.swing(0, 4)).isEqualTo(Judgment.NOTHING);
    }
}
