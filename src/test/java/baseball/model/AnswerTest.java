package baseball.model;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AnswerTest {

    @Test
    void 정답을_생성한다() {
        // given, when
        Answer answer = new Answer();

        // then
        assertThat(answer.fetchDigits()).hasSize(3);
    }

}