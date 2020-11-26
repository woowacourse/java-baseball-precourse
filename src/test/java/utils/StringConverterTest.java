package utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringConverterTest {
    @Test
    public void toIntList_메서드_동작_확인() {
        //given
        String origin = "12345";

        //when
        List<Integer> convertedList = StringConverter.toIntList(origin);

        //then
        assertThat(convertedList).containsExactly(1, 2, 3, 4, 5);
    }
}