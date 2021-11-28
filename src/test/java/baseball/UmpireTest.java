package baseball;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class UmpireTest {

    final String opponentNumber = "425";
    Umpire umpire = new Umpire(opponentNumber);

    final HashMap<String, String> testCase = new HashMap<String, String>() {
        {
            put("513", "1볼");
            put("426", "2스트라이크");
            put("542", "3볼");
            put("425", "3스트라이크");
            put("917", "낫싱");
        }
    };

    @Test
    public void judgeRoundTest() {

        for (Map.Entry<String, String> entry : testCase.entrySet()) {

            String userNumber = entry.getKey();
            String result = entry.getValue();

            Assertions.assertEquals(result, umpire.judgeRound(userNumber), "카운팅이 룰을 따르지 않음");
        }
    }
}
