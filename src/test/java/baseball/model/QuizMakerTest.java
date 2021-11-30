package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class QuizMakerTest {

    private static final int LENGTH_OF_QUIZ = 3;

    @Test
    @DisplayName("문제 생성 테스트")
    public void createNewQuiz() {
        List<Integer> newQuiz = QuizMaker.createNewQuiz();
        assertThat(newQuiz.size()).isEqualTo(LENGTH_OF_QUIZ);

        Set<Integer> newQuizSet = new HashSet<>(newQuiz);
        assertThat(newQuizSet.size()).isEqualTo(LENGTH_OF_QUIZ);
    }

}