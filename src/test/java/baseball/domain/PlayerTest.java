package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Computer computer = Computer.getInstance();
    RandomGenerator randomGenerator = RandomGenerator.getInstance();
    Player player = Player.getInstance();

    @Test
    @DisplayName("플레이어 생성 및 tryNumber 사용자에게 입력받아서 Computer에게 건네주기")
    void test() {
        int[] answer = computer.getAnswer();

        // given
        player.playerInput("143");

        // when
        int[] hint = computer.generateHint(player.submitTryNumber());

        // then
        System.out.println("===ANSWER===");
        showArray(answer);
        System.out.println("===ANSWER===");
        System.out.println("===TRY_NUMBER===");
        showArray(player.submitTryNumber());
        System.out.println("===TRY_NUMBER===");
        System.out.println("BALL : " + hint[0]);
        System.out.println("STRIKE : " + hint[1]);
    }

    private void showArray(int[] answer) {
        for (int ans : answer) {
            System.out.print(ans + " ");
        }
        System.out.println("");
    }

}