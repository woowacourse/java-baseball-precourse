package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;
    @BeforeEach
    void init(){
       calculator = new Calculator(157,537);
    }

    @Test
    void countBall() {
        assertEquals(1, calculator.countBall());
    }

    @Test
    void countStrike() {
        assertEquals(1, calculator.countStrike());
    }
}