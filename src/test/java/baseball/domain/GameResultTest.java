package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {
    GameResult gameResult;

    @BeforeEach
    void 게임결과_테스트_기본설정() {
        gameResult = new GameResult();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "789"})
    void 스트라이크_3_검증(String value) {
        BaseballNums answerBaseballNums = new BaseballNums(makeConvertStringToInt(value));
        BaseballNums playerBaseballNums = new BaseballNums(makeConvertStringToInt(value));
        gameResult.checkResult(answerBaseballNums, playerBaseballNums);
        assertAll(() -> {
            assertEquals(gameResult.getStrikeCount(), 3);
            assertEquals(gameResult.getBallCount(), 0);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"123:132", "789: 879"}, delimiter = ':')
    void 스트라이크_1_볼_2_검증(String answerValue, String playerValue) {
        BaseballNums answerBaseballNums = new BaseballNums(makeConvertStringToInt(answerValue));
        BaseballNums playerBaseballNums = new BaseballNums(makeConvertStringToInt(playerValue));
        gameResult.checkResult(answerBaseballNums, playerBaseballNums);
        assertAll(() -> {
            assertEquals(gameResult.getStrikeCount(), 1);
            assertEquals(gameResult.getBallCount(), 2);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"416:641", "234:423"}, delimiter = ':')
    void 볼_3_검증(String answerValue, String playerValue) {
        BaseballNums answerBaseballNums = new BaseballNums(makeConvertStringToInt(answerValue));
        BaseballNums playerBaseballNums = new BaseballNums(makeConvertStringToInt(playerValue));
        gameResult.checkResult(answerBaseballNums, playerBaseballNums);
        assertAll(() -> {
            assertEquals(gameResult.getStrikeCount(), 0);
            assertEquals(gameResult.getBallCount(), 3);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"123:456", "357:468"}, delimiter = ':')
    void 낫싱_검증(String answerValue, String playerValue) {
        BaseballNums answerBaseballNums = new BaseballNums(makeConvertStringToInt(answerValue));
        BaseballNums playerBaseballNums = new BaseballNums(makeConvertStringToInt(playerValue));
        gameResult.checkResult(answerBaseballNums, playerBaseballNums);
        assertAll(() -> {
            assertEquals(gameResult.getStrikeCount(), 0);
            assertEquals(gameResult.getBallCount(), 0);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "789"})
    void 스트라이크_3인경우_승리_검증(String value) {
        BaseballNums answerBaseballNums = new BaseballNums(makeConvertStringToInt(value));
        BaseballNums playerBaseballNums = new BaseballNums(makeConvertStringToInt(value));
        gameResult.checkResult(answerBaseballNums, playerBaseballNums);
        assertEquals(gameResult.isValidateWinner(), false);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:456", "357:468"}, delimiter = ':')
    void 스트라이크_3이_아닌경우_패배_검증(String answerValue, String playerValue) {
        BaseballNums answerBaseballNums = new BaseballNums(makeConvertStringToInt(answerValue));
        BaseballNums playerBaseballNums = new BaseballNums(makeConvertStringToInt(playerValue));
        gameResult.checkResult(answerBaseballNums, playerBaseballNums);
        assertEquals(gameResult.isValidateWinner(), true);
    }

    private List<Integer> makeConvertStringToInt(String value) {
        return Arrays.asList(value.split("")).stream()
                .map(Integer::valueOf).collect(Collectors.toList());
    }
}