package baseball.model;

import baseball.constant.Constant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerNumberTest {
    AnswerNumber answerNumber;

    @BeforeEach
    void setUp() {
        answerNumber = new AnswerNumber();
    }

    @Test
    void answerNumberGenerate() {
        assertThat(Integer.parseInt(answerNumber.getAnswerNumber()))
                .isBetween(123,999);

        for (int i = 0; i < 3; i++) {
            assertThat(answerNumber.getAnswerNumber().charAt(0))
                    .isNotEqualTo(answerNumber.getAnswerNumber().charAt(1))
                    .isNotEqualTo(answerNumber.getAnswerNumber().charAt(2));

        }
    }

}