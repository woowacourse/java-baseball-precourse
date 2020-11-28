package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.Baseballs;

public class BaseballsTest {

    Baseballs baseballs;

    @BeforeEach
    public void initBaseballs() {
        baseballs = new Baseballs("123");
    }

    @Test
    @DisplayName("입력받은 3자리 숫자 list 생성 테스트")
    public void addNumbersTest() {
        assertThat(baseballs.getNumbers()).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("인덱스에 해당하는 값 반환 테스트")
    public void getNumberTest() {
        assertThat(baseballs.getNumber(1)).isEqualTo(2);
    }

    @Test
    @DisplayName("같은 인덱스에 같은 값일 경우 true 를 반환 테스트")
    public void isStrikeTest() {
        assertTrue(baseballs.isStrike(1, 2));
    }

    @Test
    @DisplayName("같은 인덱스에 다른 값일 경우 true 를 반환 테스트")
    public void isNotStrikeTest() {
        assertFalse(baseballs.isStrike(1, 3));
    }

    @Test
    @DisplayName("List가 값을 가지고 있을 경우 true 를 반환 테스트")
    public void isBallTest() {
        assertTrue(baseballs.isBall(2));
    }

    @Test
    @DisplayName("List가 값을 가지고 있지 않을 경우 false 를 반환 테스트")
    public void isNotBallTest() {
        assertFalse(baseballs.isBall(4));
    }
}
