package domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumbersTest {

    @DisplayName("BaseballNumbers를 자동 생성하면, 중복되지 않은 3개의 숫자가 뽑힘")
    @Test
    public void BaseballNumbers_자동_생성_중복_없는_랜덤_3개_숫자_반환() {
        BaseballNumbers baseballNumbers = BaseballNumbers.generateAutomatic();
        int distinctNumberCounts = baseballNumbers.getBaseballNumbers()
                .stream()
                .distinct()
                .count();

        assertThat(distinctNumberCounts).isEqualTo(3);
    }
}
