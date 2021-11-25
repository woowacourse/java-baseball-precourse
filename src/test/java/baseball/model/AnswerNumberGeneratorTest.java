package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnswerNumberGeneratorTest {
    AnswerNumberGenerator answerNumberGenerator;

    @BeforeEach
    void setUp() {
        answerNumberGenerator = new AnswerNumberGenerator();
    }

    @Test
    void answerNumberGenerateTest() {
        assertThat(answerNumberGenerator.GetAnswerNumber())
                .size()
                .isEqualTo(3);

        for (int i = 0; i < 3; i++) {
            assertThat(answerNumberGenerator.GetAnswerNumber()
                    .get(i))
                    .isBetween(1, 9);
        }
    }
}