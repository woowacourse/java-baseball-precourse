package number;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NumbersTest {

    @Test
    @DisplayName("볼을 체크한다")
    void checkBall() {
        //given
        List<Number> gameNumber = new ArrayList<>();
        List<Number> gameNumber2 = new ArrayList<>();
        List<Integer> randomList = Arrays.asList(new Integer[]{2, 1, 3});
        List<Integer> inputList = Arrays.asList(new Integer[]{4, 2, 3});
        List<Integer> randomList2 = Arrays.asList(new Integer[]{2, 1, 4});
        List<Integer> inputList2 = Arrays.asList(new Integer[]{4, 2, 1});

        gameNumber.add(Number.of(randomList));
        gameNumber.add(Number.of(inputList));
        gameNumber2.add(Number.of(randomList2));
        gameNumber2.add(Number.of(inputList2));

        //when
        Numbers numbers = Numbers.of(gameNumber);
        Numbers numbers2 = Numbers.of(gameNumber2);

        //then
        Assertions.assertThat(numbers.checkBall()).isEqualTo(1);
        Assertions.assertThat(numbers2.checkBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("스트라이크를 체크한다")
    void checkStrike() {
        //given
        List<Number> gameNumber = new ArrayList<>();
        List<Number> gameNumber2 = new ArrayList<>();
        List<Integer> randomList = Arrays.asList(new Integer[]{2, 1, 3});
        List<Integer> inputList = Arrays.asList(new Integer[]{4, 2, 3});
        List<Integer> randomList2 = Arrays.asList(new Integer[]{4, 2, 1});
        List<Integer> inputList2 = Arrays.asList(new Integer[]{4, 2, 1});

        gameNumber.add(Number.of(randomList));
        gameNumber.add(Number.of(inputList));
        gameNumber2.add(Number.of(randomList2));
        gameNumber2.add(Number.of(inputList2));

        //when
        Numbers numbers = Numbers.of(gameNumber);
        Numbers numbers2 = Numbers.of(gameNumber2);

        //then
        Assertions.assertThat(numbers.checkStrike()).isEqualTo(1);
        Assertions.assertThat(numbers2.checkStrike()).isEqualTo(3);
    }
}