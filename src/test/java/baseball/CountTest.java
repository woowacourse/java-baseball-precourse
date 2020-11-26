package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Count;

public class CountTest {

    @Test
    @DisplayName("카운트의 속성은 1을 반환")
    public void increaseCountTest() {
        Count count = new Count();
        count.increaseCount();
        assertThat(count.getCount()).isEqualTo(1);
    }
}
