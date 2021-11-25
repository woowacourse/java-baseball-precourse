package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RandomGeneratorTest {
    RandomGenerator randomGenerator = RandomGenerator.getInstance();

    @Test
    @DisplayName("정답에 겹치는 숫자가 있는지")
    void checkDuplicated() {
        int[] arr = randomGenerator.getAnswer();
        showArray(arr);
        assertThat(arr[0]).isNotSameAs(arr[1]);
        assertThat(arr[0]).isNotSameAs(arr[2]);
        assertThat(arr[1]).isNotSameAs(arr[2]);
    }

    @Test
    @DisplayName("난수 1개 생성 후 재생성 하여 다른지 확인")
    void generateRandomNumber() {
        // given
        int[] arr1 = randomGenerator.getAnswer();
        showArray(arr1);

        // 재생성
        randomGenerator.reGenerate();

        int[] arr2 = randomGenerator.getAnswer();
        showArray(arr2);

        // when
        // No Regenerate
        int[] arr3 = randomGenerator.getAnswer();
        showArray(arr3);

        // then
        assertThat(arr2).isNotEqualTo(arr2);
        assertThat(arr2).containsExactly(arr3);
    }

    private void showArray(int[] arr) {
        for (int ans : arr) {
            System.out.print(ans + " ");
        }
        System.out.println("");
    }
}