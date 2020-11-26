package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {

    @DisplayName("BaseballGame을 시작하는 기능을 테스트한다 ")
    @Test
    void testBaseballGamePlayFunction() {
        //given
        List<BaseballNumber> baseballNumbers = Arrays.asList(1, 2, 3).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList());
        //when
        BaseballGame baseballGame = BaseballGame.play(() -> baseballNumbers);

        //then
        assertThat(baseballGame).extracting("playing").isEqualTo(true);
        assertThat(baseballGame).extracting("baseballNumbers")
                .usingRecursiveComparison()
                .isEqualTo(new BaseballNumbers(baseballNumbers));
    }

    @DisplayName("스트라이크 개수를 세는 기능을 테스트한다 ")
    @ParameterizedTest
    @CsvSource(value = {"123:3", "124:2", "135:1", "234:0"}, delimiter = ':')
    void testCountStrikeFunction(String inputNumber, int expectedStrikeNumber) {
        //given
        List<BaseballNumber> answerBaseballNumbers = Arrays.asList(1, 2, 3).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList());
        BaseballGame baseballGame = BaseballGame.play(() -> answerBaseballNumbers);

        BaseballNumbers baseballNumbers = new BaseballNumbers(Arrays.stream(inputNumber.split(""))
                .map(Integer::new)
                .map(BaseballNumber::new)
                .collect(Collectors.toList()));

        //when
        int strikeNumber = baseballGame.countStrike(baseballNumbers);

        //then
        assertThat(strikeNumber).isEqualTo(expectedStrikeNumber);
    }

    @DisplayName("볼 개수를 세는 기능을 테스트한다 ")
    @ParameterizedTest
    @CsvSource(value = {"123:0", "135:1", "234:2", "312:3"}, delimiter = ':')
    void testCountBallFunction(String inputNumber, int expectedBallNumber) {
        //given
        List<BaseballNumber> answerBaseballNumbers = Arrays.asList(1, 2, 3).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList());
        BaseballGame baseballGame = BaseballGame.play(() -> answerBaseballNumbers);

        BaseballNumbers baseballNumbers = new BaseballNumbers(Arrays.stream(inputNumber.split(""))
                .map(Integer::new)
                .map(BaseballNumber::new)
                .collect(Collectors.toList()));

        //when
        int ballNumber = baseballGame.countBall(baseballNumbers);

        //then
        assertThat(ballNumber).isEqualTo(expectedBallNumber);
    }

    @DisplayName("정답과 일치하는 세자리 숫자를 입력했을 때, 정답과 일치하는지 확인하는 기능을 테스트한다 ")
    @Test
    void testIsCorrectToFunctionIfInputCorrectBaseballNumbers() {
        //given
        List<BaseballNumber> answerBaseballNumbers = Arrays.asList(1, 2, 3).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList());
        BaseballGame baseballGame = BaseballGame.play(() -> answerBaseballNumbers);

        BaseballNumbers baseballNumbers = new BaseballNumbers(Arrays.asList(1, 2, 3).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList()));

        //when
        boolean corrected = baseballGame.isCorrectTo(baseballNumbers);

        //then
        assertThat(corrected).isTrue();
    }

    @DisplayName("틀린 세자리 숫자를 입력했을 때, 정답과 일치하는지 확인하는 기능을 테스트한다 ")
    @Test
    void testIsCorrectToFunctionIfInputNotCorrectBaseballNumbers() {
        //given
        List<BaseballNumber> answerBaseballNumbers = Arrays.asList(1, 2, 3).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList());
        BaseballGame baseballGame = BaseballGame.play(() -> answerBaseballNumbers);

        BaseballNumbers baseballNumbers = new BaseballNumbers(Arrays.asList(1, 2, 4).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList()));

        //when
        boolean corrected = baseballGame.isCorrectTo(baseballNumbers);

        //then
        assertThat(corrected).isFalse();
    }

    @DisplayName("숫자야구게임을 종료하는 기능을 테스트한다 ")
    @Test
    void testStopFunction() {
        //given
        BaseballGame baseballGame = BaseballGame.play(() -> Arrays.asList(1, 2, 3).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList()));

        //when
        baseballGame.stop();

        //then
        assertThat(baseballGame.isPlaying()).isFalse();
    }

    @DisplayName("재시작 요청을 입력했을 때, 숫자야구게임을 재시작하는 기능을 테스트한다 ")
    @Test
    void testRestartFunctionIfInputRestartRequest() {
        //given
        BaseballNumbersGenerator baseballNumbersGenerator = () -> Arrays.asList(1, 2, 3).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList());
        BaseballGame baseballGame = BaseballGame.play(baseballNumbersGenerator);

        baseballGame.stop();

        //when
        String restartRequest = "1";
        baseballGame.restart(new RestartManager(restartRequest), baseballNumbersGenerator);

        //then
        assertThat(baseballGame.isPlaying()).isTrue();
    }

    @DisplayName("종료 요청을 입력했을 때, 숫자야구게임을 재시작하는 기능을 테스트한다 ")
    @Test
    void testRestartFunctionIfInputStopRequest() {
        //given
        BaseballNumbersGenerator baseballNumbersGenerator = () -> Arrays.asList(1, 2, 3).stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList());
        BaseballGame baseballGame = BaseballGame.play(baseballNumbersGenerator);

        baseballGame.stop();

        //when
        String stopRequest = "2";
        baseballGame.restart(new RestartManager(stopRequest), baseballNumbersGenerator);

        //then
        assertThat(baseballGame.isPlaying()).isFalse();
    }
}
