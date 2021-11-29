package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.constants.NumberListConstraints;
import baseball.domain.TargetNumber;
import baseball.utils.NumberListGenerator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TargetNumberTest {

    @DisplayName("생성되는 숫자리스트의 길이와 중복값을 확인한다")
    @Test
    void targetNumberValidationTest() {
        List<Integer> numbers = NumberListGenerator.generateNonDuplicateNumbers(
            NumberListConstraints.LIST_LENGTH.value(),
            NumberListConstraints.MIN_NUMBER.value(),
            NumberListConstraints.MAX_NUMBER.value()
        );
        assertEquals(numbers.size(), NumberListConstraints.LIST_LENGTH.value());
        Set<Integer> set = new HashSet<>(numbers);
        assertEquals(numbers.size(), set.size());
    }

    @DisplayName("잘못된 숫자 리스트에 대한 검증을 테스트한다")
    @Test
    void validateTest() {
        List<Integer> duplicateTest = Arrays.asList(1, 1, 1);
        List<Integer> lengthTest = Arrays.asList(1, 2);

        assertThrows(
            IllegalArgumentException.class,
            () -> new TargetNumber(duplicateTest)
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> new TargetNumber(lengthTest)
        );
    }
}
