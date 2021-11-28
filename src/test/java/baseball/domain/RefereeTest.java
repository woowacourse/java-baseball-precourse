package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import baseball.resource.GameRule;

public class RefereeTest {

    private static Referee referee = new Referee();
    private static Player player = new Player(referee);

    @Test
    void 랜덤값생성_자릿수확인() {
        List<Integer> randomNumbers = makeRandomNumbers();

        assertThat(randomNumbers.size()).isEqualTo(GameRule.NUMBERS_DIGITS);
    }

    @Test
    void 랜덤값생성_중복포함확인() {
        List<Integer> randomNumbers = makeRandomNumbers();

        for (int i = 1; i < GameRule.NUMBERS_DIGITS; i++) {
            assertThat(randomNumbers.get(i-1)).isNotEqualTo(randomNumbers.get(i));
        }
    }

    @Test
    void 랜덤값생성_범위내숫자로구성되었는지_확인() {
        List<Integer> randomNumbers = makeRandomNumbers();

        for (int number : randomNumbers) {
            assertTrue(GameRule.NUMBER_GAME_PLAY <= number && number <= GameRule.NUMBERS_END_INCLUSION);
        }
    }

    @Test
    void 숫자배열_비교로직_정상작동확인() {
        List<Integer> targetNumbers = convertIntArrayToArrayList(new int[] {1,2,3});
        setRefereeNumbers(targetNumbers);

        List<Integer> playerNumbers = convertIntArrayToArrayList(new int[] {1,2,3});
        String result = getEvaluatedResult(playerNumbers);
        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    void 숫자배열_비교로직_작동실패확인() {
        List<Integer> targetNumbers = convertIntArrayToArrayList(new int[] {1,2,3});
        setRefereeNumbers(targetNumbers);

        List<Integer> playerNumbers = convertIntArrayToArrayList(new int[] {1,2,8});
        String result = getEvaluatedResult(playerNumbers);
        assertThat(result).isNotEqualTo("3스트라이크");
    }

    private List<Integer> makeRandomNumbers() {
        referee.pickRandomNumbers();
        return referee.getTargetNumbers();
    }

    private List<Integer> convertIntArrayToArrayList(int[] numbers) {
        return Arrays.stream(numbers).boxed().collect(Collectors.toList());
    }

    private String getEvaluatedResult(List<Integer> playerNumbers) {
        player.pickPlayerNumbers(playerNumbers);
        player.evaluateNumbers();
        return player.getHintAsString();
    }

    private void setRefereeNumbers(List<Integer> targetNumbers) {
        referee.setTargetNumbers(targetNumbers);
        boolean[] booleanBits = new boolean[10];
        for (int number : targetNumbers) {
            booleanBits[number] = true;
        }
        referee.setBooleanBits(booleanBits);
    }

}
