package view;

import computer.result.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static computer.result.Result.BALL;
import static computer.result.Result.NOTHING;
import static computer.result.Result.STRIKE;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ResultViewTest {

    @DisplayName("결과 문구 출력")
    @Test
    void getComment() {
        Results results = new Results(Arrays.asList(STRIKE, BALL, NOTHING));

        assertThat(ResultView.getComment(results)).isEqualTo("1 스트라이크 1 볼");
    }
}