package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class NumberComparatorTest {

    @Test
    public void compareTwoList() throws Exception {
        //given
        List<Integer> target = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        List<Integer> comparator = new ArrayList<Integer>(Arrays.asList(1, 4, 2));
        Map<String, Integer> expectedScore = new HashMap<String, Integer>();
        expectedScore.put("strike", 1);
        expectedScore.put("ball", 1);

        //when
        Map<String, Integer> score = NumberComparator
            .compareTwoBalls(target, comparator);

        //then
        assertEquals(expectedScore, score);

    }
}