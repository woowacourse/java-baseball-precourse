package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    @Test
    public void generateNumber() throws Exception{
        //given
        NumberGenerator numberGenerator = new NumberGenerator();
        int length = 3;

        //when
        List<Integer> numbers = numberGenerator.generateNumber();

        //then
        assertEquals(length, numbers.size());
    }

}