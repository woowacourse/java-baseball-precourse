package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    @Test
    public void generateNumber() throws Exception{
        //given
        int length = 3;

        //when
        Balls balls = NumberGenerator.generateNumber();

        //then
        assertEquals(length, balls.getBalls().size());
    }

}