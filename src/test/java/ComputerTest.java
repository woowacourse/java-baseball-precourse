import baseball.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    Computer computer;

    @BeforeEach
    public void computer_객체초기화() {
        computer = new Computer();
    }

    @Test
    public void 랜덤숫자_생성된다() {
        System.out.println(computer.getNumber());
        assertThat(computer.getNumber().length()).isEqualTo(3);
    }
}
