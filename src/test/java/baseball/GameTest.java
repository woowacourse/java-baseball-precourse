package baseball;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    final String opponentNumber = "425";
    Umpire umpire = new Umpire(opponentNumber);

    @Test
    public void countStrikeTest() {
        final HashMap<String, Integer> testCase = new HashMap<String, Integer>() {{//초기값 지정
            put("123", 1);
            put("897", 0);
            put("495", 2);
            put("444", 1);
            put("425", 3);
        }};



        for (Map.Entry<String, Integer> entry : testCase.entrySet()) {

            String key = entry.getKey();
            Integer result = entry.getValue();

            Assertions.assertEquals(result, umpire.countStrike(opponentNumber, key), "카운팅이 룰을 따르지 않음");

        }

    }

    @Test
    public void countBallTest() {

        final HashMap<String, Integer> testCase = new HashMap<String, Integer>() {{
            put("111", 0);
            put("589", 1);
            put("254", 3);
            put("842", 2);
        }};

        for (Map.Entry<String, Integer> entry : testCase.entrySet()) {

            String key = entry.getKey();
            Integer result = entry.getValue();

            Assertions.assertEquals(result, umpire.countBall(opponentNumber, key), "카운팅이 룰을 따르지 않음");

        }
    }
}