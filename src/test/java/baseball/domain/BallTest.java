package baseball.domain;

import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    private static final int NUMBER_RANGE_ONE = 1;
    private static final int NUMBER_RANGE_NINE = 9;
    private static final int NUMBER_COUNT = 3;

    @Test
    public void 범위_1_9_까지_서로다른_임의의수_3개를_생성한다() {
        //given
        List<Integer> numbers = new ArrayList<>();
        int num;

        //when
        while(numbers.size() < NUMBER_COUNT) {
            num = RandomUtils.nextInt(NUMBER_RANGE_ONE, NUMBER_RANGE_NINE);
            if(!numbers.contains(num)) {
                numbers.add(num);
            }
        }

        //then
        assertThat(numbers.size()).isEqualTo(NUMBER_COUNT);
        assertThat(numbers.stream()
                .distinct()
                .count() != numbers.size());
    }

    @Test
    public void 문자열을_정수형리스트로_변환한다() throws Exception {
        //given
        String str = "123";

        //when
        List<Integer> list = Arrays.stream(str.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //then
        System.out.println(list);
    }
}