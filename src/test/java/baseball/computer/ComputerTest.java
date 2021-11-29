package baseball.computer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    private Computer computer;

    @BeforeEach
    void init() {
        computer = new Computer();
    }

    @Test
    @DisplayName("난수 생성")
    void 난수_생성() {
        assertThat(computer.getNumber()).isInstanceOf(Integer.class);
    }
}
