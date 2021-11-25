package baseball.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class AnswerGeneratorTest {

    private final int startInclusive = 1;
    private final int endInclusive = 9;
    private final int count = 3;

    @Test
    void generate_valid_size_test() {
        //given
        AnswerGenerator answerGenerator = new AnswerGenerator(startInclusive, endInclusive, count);

        //when
        List<Integer> answer = answerGenerator.generate();

        //then
        assertThat(answer.size()).isEqualTo(3);
    }

}