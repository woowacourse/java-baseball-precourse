package baseball.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StringParseUtilTest {

    @Test
    public void 숫자변환검사() {

        //given
        String userNumber = "123";
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3);

        //when
        List<Integer> convertedNumbers = StringParseUtil.parseToInteger(userNumber);

        //then
        assertArrayEquals(convertedNumbers.toArray(), expectedNumbers.toArray());
    }
}