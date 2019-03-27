package baseball.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class GameResultUtilTest {

    @Test
    public void 쓰리스트라이크() {

        //given
        List<Integer> userNumbers = Arrays.asList(2, 1, 3);
        List<Integer> computerNumbers = Arrays.asList(2, 1, 3);
        List<Integer> expectedResultNumbers = Arrays.asList(3, 0);

        //when
        List<Integer> resultNumbers = GameResultUtil.generateResult(userNumbers, computerNumbers);

        //then
        assertArrayEquals(expectedResultNumbers.toArray(), resultNumbers.toArray());
    }

    @Test
    public void 원스트라이크_투폴() {

        //given
        List<Integer> userNumbers = Arrays.asList(2, 1, 3);
        List<Integer> computerNumbers = Arrays.asList(2, 3, 1);
        List<Integer> expectedResultNumbers = Arrays.asList(1, 2);

        //when
        List<Integer> resultNumbers = GameResultUtil.generateResult(userNumbers, computerNumbers);

        //then
        assertArrayEquals(expectedResultNumbers.toArray(), resultNumbers.toArray());
    }

    @Test
    public void 노스트라이크노볼() {
        //given
        List<Integer> userNumbers = Arrays.asList(2, 1, 3);
        List<Integer> computerNumbers = Arrays.asList(4, 7, 8);
        List<Integer> expectedResultNumbers = Arrays.asList(0, 0);

        //when
        List<Integer> resultNumbers = GameResultUtil.generateResult(userNumbers, computerNumbers);

        //then
        assertArrayEquals(expectedResultNumbers.toArray(), resultNumbers.toArray());
    }
}