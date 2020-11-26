package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Count;

public class CountTest {

    @Test
    @DisplayName("카운트의 속성이 증가되는지 테스트")
    public void increaseCountTest() {
        Count count = new Count();
        count.increaseCount();
        assertThat(count.getCount()).isEqualTo(1);
    }
}
