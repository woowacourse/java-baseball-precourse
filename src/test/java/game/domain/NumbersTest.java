
/*
 * NumbersTest.java
 * @author crystal_rim
 * @version 1.0.0
 * @date 2019-12-02
 */
package game.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {
    @Test
    void 입력_정상() throws Exception {
        // given
        String input = "123";
        // when
        Numbers numbers = Numbers.valueOf(input);
        // then
        assertThat(numbers.getSize()).isEqualTo(3);
    }

    @Test
    void 입력_실패_숫자중복() {
        // given
        String input = "112";
        // when
        // then
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> Numbers.valueOf(input));
        assertThat(runtimeException.getMessage()).isEqualTo("잘못된 입력");
    }

    @Test
    void 입력_실패_0포함() {
        // given
        String input = "120";
        // when
        // then
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> Numbers.valueOf(input));
        assertThat(runtimeException.getMessage()).isEqualTo("잘못된 입력");
    }

    @Test
    void 입력_실폐_숫자아닌경우() {
        // given
        String input = "1!2";
        // when
        // then
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> Numbers.valueOf(input));
        assertThat(runtimeException.getMessage()).isEqualTo("잘못된 입력");
    }
}