package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SecretAnswerTest {

    @DisplayName("유저 인풋과 비교하여 같은 수가 같은 자리에 있다면 스트라이크로 다른 자리에 있다면 볼로 판단한다")
    @Test
    void compareWithUserInput() {
        //given
        SecretAnswer secretAnswer = new SecretAnswer(new int[]{1, 7, 5});
        int[] userInput = {1, 5, 7};

        //when
        JudgeResult result = secretAnswer.compareWith(userInput);

        //then
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(2);
    }
}
