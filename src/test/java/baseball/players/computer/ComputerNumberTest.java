package baseball.players.computer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.players.Computer;
import baseball.players.numbers.ComputerNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerNumberTest {

    @DisplayName("컴퓨터가 생성한 번호가 유효한지")
    @Test
    void allowedComputerNumberTest() {
        ComputerNumbers computerNumbers = new ComputerNumbers();
        computerNumbers.generateNumber();
        assertDoesNotThrow(computerNumbers::checkNumbers);
    }

    @DisplayName("테스트시 잘못된 번호로 초기화하면 IllegalArgumentException 발생")
    @Test
    void notAllowedComputerNumberTest() {
        int notAllowedNumber = 102;
        Computer computer = new Computer();
        assertThrows(IllegalArgumentException.class, () -> {
            computer.initializeNumbersWith(notAllowedNumber);
        });
    }
}
