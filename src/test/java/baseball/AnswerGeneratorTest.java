package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerGeneratorTest {

    @DisplayName("생성된 정답에는 중복된 숫자가 없어야 한다")
    @Test
    void generate_unique_numbers() {
        //given
        AnswerGenerator answerGenerator = new AnswerGenerator();

        //when
        int[] answer = answerGenerator.generate();

        //then
        HashSet<Integer> set = new HashSet<>();
        for(int digit : answer) {
            set.add(digit);
        }

        assertThat(set).hasSize(answer.length);
    }
}
