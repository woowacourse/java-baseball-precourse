package number;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NumberTest {

    @Test
    @DisplayName("입력값의 각 자리수는 달랴아 한다")
    void validateDigit() {
        //given
        List<Integer> integers = Arrays.asList(new Integer[]{1, 2, 3});
        List<Integer> integers2 = Arrays.asList(new Integer[]{4, 5, 6});

        //when
        Number number = Number.of(integers);
        Number number2 = Number.of(integers2);

        //then
        assertThat(number.getNumbers()).isEqualTo(integers);
        assertThat(number2.getNumbers()).isEqualTo(integers2);
    }

    @Test
    @DisplayName("입력 값에 0이 있을시, 에러가 발생한다")
    void validateNaturalNumberError() {
        //given
        List<Integer> integers = Arrays.asList(new Integer[]{0, 2, 3});
        List<Integer> integers2 = Arrays.asList(new Integer[]{4, 0, 4});
        List<Integer> integers3 = Arrays.asList(new Integer[]{0, 0, 0});

        //then
        assertThatThrownBy(() -> Number.of(integers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자연수만 입력해 주세요");

        assertThatThrownBy(() -> Number.of(integers2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자연수만 입력해 주세요");

        assertThatThrownBy(() -> Number.of(integers3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자연수만 입력해 주세요");
    }

    @Test
    @DisplayName("입력 값의 각 자리수가 같을 떄, 에러가 발생한다")
    void validateDigitFail() {
        //given
        List<Integer> integers = Arrays.asList(new Integer[]{2, 2, 3});
        List<Integer> integers2 = Arrays.asList(new Integer[]{4, 5, 4});
        List<Integer> integers3 = Arrays.asList(new Integer[]{4, 4, 4});

        //then
        assertThatThrownBy(() -> Number.of(integers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("각 자릿 수는 모두 달라야 합니다");

        assertThatThrownBy(() -> Number.of(integers2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("각 자릿 수는 모두 달라야 합니다");

        assertThatThrownBy(() -> Number.of(integers3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("각 자릿 수는 모두 달라야 합니다");
    }

    @Test
    @DisplayName("랜덤 숫자 리스트를 생성해야 한다")
    void randomNumberList() {
        //give
        List<Integer> tmpList = new ArrayList<>();

        //when
        List<Integer> randomList = Number.createRandoms(3);
        for (Integer integer : randomList) {
            if (!tmpList.contains(integer)) {
                tmpList.add(integer);
            }
        }

        //then
        Assertions.assertThat(randomList.size()).isEqualTo(tmpList.size());
    }
}
