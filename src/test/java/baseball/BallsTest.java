package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsTest {

    @DisplayName("숫자 리스트를 Ball 리스트로 변환")
    @Test
    void convertNumbersToBalls() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        Balls actual = new Balls(numbers);
        List<Ball> expected = new ArrayList<>();
        expected.add(new Ball(1));
        expected.add(new Ball(2));
        expected.add(new Ball(3));
        assertThat(Arrays.equals(
            actual.getList().toArray(),
            expected.toArray()
            )).isTrue();
    }

    @DisplayName("중복된 수를 가진 Ball이 있는지 검사")
    @Test
    void validateDuplication() {
        List<Integer> numbers = Arrays.asList(1, 2, 2);
        assertThatThrownBy(() -> new Balls(numbers))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
