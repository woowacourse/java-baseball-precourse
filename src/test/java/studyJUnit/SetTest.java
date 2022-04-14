package studyJUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {

        //given
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항 1 : Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    void 셋_사이즈_테스트() {

        // then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항 2 : Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.")
    @ParameterizedTest
    @ValueSource(ints = {1 ,2, 3})
    void 셋이_포함하는_숫자_테스트(int input) {

        //then
        assertThat(numbers).contains(input);
    }

    @DisplayName("요구사항 3 : 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true","3:true", "4:false", "5:false"}, delimiter = ':')
    void 셋에서_특정값은_트루_다른값은_폴스_테스트(int input, boolean expected) {

        // then
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
