package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Computer computer = Computer.getInstance();
    RandomGenerator randomGenerator = RandomGenerator.getInstance();

    @Test
    @DisplayName("플레이어 생성 및 tryNumber 사용자에게 입력받아서 Computer에게 건네주기")
    void test() {
        Player player = new Player();
        int[] answer = computer.getAnswer();

        // given
        int[] tryNumber = player.playerInput(143);

        // when
        int[] hint = computer.generateHint(tryNumber);

        // then
        System.out.println("===ANSWER===");
        showArray(answer);
        System.out.println("===ANSWER===");
        System.out.println("===TRY_NUMBER===");
        showArray(tryNumber);
        System.out.println("===TRY_NUMBER===");
        System.out.println("BALL : " + hint[0]);
        System.out.println("STRIKE : " + hint[1]);
    }

    @Test
    @DisplayName("잘못된 입력이 들어오면 Exception")
    void illegalInput() {
        Player player = new Player();
        int[] answer = computer.getAnswer();

        // given
        int playerInput = 1000;

        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> player.playerInput(playerInput));

        // then
        Assertions.assertThat(e).isInstanceOf(IllegalArgumentException.class);
    }

    private void showArray(int[] answer) {
        for (int ans : answer) {
            System.out.print(ans + " ");
        }
        System.out.println("");
    }

}