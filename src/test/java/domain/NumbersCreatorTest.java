package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersCreatorTest {

    @Test
    public void 세자리수_생성_확인() {
        //given
        List<Integer> numbers;

        //when
        numbers = NumbersCreator.getNumbers();

        // then
        assertThat(numbers).hasSize(3);
        assertThat(numbers).allMatch(integer -> integer >= 1 && integer <= 9);
        assertThat(numbers).doesNotHaveDuplicates();
    }
}