package computer.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResultsTest {

    @DisplayName("결과 일급컬렉션 생성")
    @Test
    void crate() {
        List<Result> allResult = Arrays.asList(Result.STRIKE, Result.BALL, Result.NOTHING);
        Results results = new Results(allResult);

        assertThat(results).isEqualTo(new Results(Arrays.asList(Result.STRIKE, Result.BALL, Result.NOTHING)));
    }

    @DisplayName("스트라이크 갯수 가져오기")
    @ParameterizedTest
    @CsvSource(value = {"STRIKE,STRIKE,STRIKE,3", "STRIKE,STRIKE,BALL,2", "STRIKE,BALL,BALL,1", "BALL,BALL,BALL,0"})
    void getStrikeAmount(Result first, Result second, Result third, int answer) {
        Results results = new Results(Arrays.asList(first, second, third));

        assertThat(results.getStrikeAmount()).isEqualTo(answer);
    }

    @DisplayName("볼 갯수 가져오기")
    @ParameterizedTest
    @CsvSource(value = {"STRIKE,STRIKE,STRIKE,0", "STRIKE,STRIKE,BALL,1", "STRIKE,BALL,BALL,2", "BALL,BALL,BALL,3"})
    void getBallAmount(Result first, Result second, Result third, int answer) {
        Results results = new Results(Arrays.asList(first, second, third));

        assertThat(results.getBallAmount()).isEqualTo(answer);
    }

    @DisplayName("스트라이크 있는지 없는지")
    @ParameterizedTest
    @CsvSource(value = {"STRIKE,true", "BALL,false"})
    void hasStrike(Result result, boolean answer) {
        Results results = new Results(Arrays.asList(result));

        assertThat(results.hasStrike()).isEqualTo(answer);
    }

    @DisplayName("볼 있는지 없는지")
    @ParameterizedTest
    @CsvSource(value = {"STRIKE,false", "BALL,true"})
    void hasBall(Result result, boolean answer) {
        Results results = new Results(Arrays.asList(result));

        assertThat(results.hasBall()).isEqualTo(answer);
    }
}