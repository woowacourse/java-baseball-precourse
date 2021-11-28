package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    private final int BALL = 0;
    private final int STRIKE = 1;
    Computer computer = Computer.getInstance();
    RandomGenerator randomGenerator = RandomGenerator.getInstance();

    @Test
    @DisplayName("정답 생성하기")
    void generateAnswer() {
        int[] answer = randomGenerator.getAnswer();
//        showArray(answer);
    }

    private void showArray(int[] answer) {
        for (int ans : answer) {
            System.out.print(ans + " ");
        }
        System.out.println("");
    }

    @Test
    @DisplayName("힌트 생성 맞는지 확인")
    void checkHint() {
        // given
        int[] answer = randomGenerator.getAnswer();
        showArray(answer);

        // when
        int[] hint = computer.generateHint(new int[]{1, 2, 3});

        // then
        System.out.println("STRIKE : " + hint[STRIKE]);
        System.out.println("BALL : " + hint[BALL]);
    }
}