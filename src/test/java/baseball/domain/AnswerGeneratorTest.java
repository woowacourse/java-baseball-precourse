package baseball.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class AnswerGeneratorTest {

    @Test
    void generate_valid_size_test() {
        //given
        AnswerGenerator answerGenerator = new AnswerGenerator();

        //when
        List<Integer> answer = answerGenerator.generate();

        //then
        assertThat(answer.size()).isEqualTo(3);
    }

}