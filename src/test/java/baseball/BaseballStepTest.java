package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BaseballStepTest {

    @Test
    public void Should_ReturnStrike_When_SameNumberAndOrderMoreThanOne() {
        int[] randomNumbers = new int[]{1, 2, 3};
        int[] playerNumbers = new int[]{1, 4, 5};

        BaseballStep baseballStep = new BaseballStep(randomNumbers, playerNumbers);
        baseballStep.compare();

        assertThat(baseballStep.toString()).isEqualTo("1스트라이크");
    }

    @Test
    public void Should_ReturnBall_When_OnlySameNumberMoreThanOne() {
        int[] randomNumbers = new int[]{1, 2, 3};
        int[] playerNumbers = new int[]{2, 1, 5};

        BaseballStep baseballStep = new BaseballStep(randomNumbers, playerNumbers);
        baseballStep.compare();

        assertThat(baseballStep.toString()).isEqualTo("2볼");
    }

    @Test
    public void Should_ReturnStrikeAndBall_When_BothSameNumberAndSameNumberOrder() {
        int[] randomNumbers = new int[]{1, 2, 3};
        int[] playerNumbers = new int[]{2, 1, 3};

        BaseballStep baseballStep = new BaseballStep(randomNumbers, playerNumbers);
        baseballStep.compare();

        assertThat(baseballStep.toString()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    public void Should_ReturnNothing_When_AnySameNumberAndOrder() {
        int[] randomNumbers = new int[]{1, 2, 3};
        int[] playerNumbers = new int[]{4, 5, 6};

        BaseballStep baseballStep = new BaseballStep(randomNumbers, playerNumbers);
        baseballStep.compare();

        assertThat(baseballStep.toString()).isEqualTo("낫싱");
    }

    @Test
    public void Should_EndGame_When_AllSameNumberAndOrder() {
        int[] randomNumbers = new int[]{1, 2, 3};
        int[] playerNumbers = new int[]{1, 2, 3};

        BaseballStep baseballStep = new BaseballStep(randomNumbers, playerNumbers);
        baseballStep.compare();

        assertThat(baseballStep.isGameEnded()).isEqualTo(true);
    }

}
