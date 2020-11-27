package players.computer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import baseball.checker.NumberChecker;
import baseball.players.numbers.ComputerNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerNumberTest {
    @DisplayName("컴퓨터가 생성한 번호가 유효한지")
    @Test
    void computerNumberTest() {
        ComputerNumbers numbers = new ComputerNumbers();
        numbers.generateNumber();

        assertDoesNotThrow(() -> {
            NumberChecker.checkNumbers(numbers.getNumbers());
        });
    }
}
