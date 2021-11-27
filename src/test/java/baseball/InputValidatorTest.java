package baseball;

import java.util.Map;
import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class InputValidatorTest {

    public static final HashMap<String, Boolean> testCase = new HashMap<String, Boolean>() {{//초기값 지정

        put("123", true);
        put("987", true);
        put("999", true);

        put("1234", false);
        put("780", false);
        put("a91", false);
        put("d", false);
        put("55", false);
        put("", false);

    }};

    @Test
    public void checkUserInput() {

        for (Map.Entry<String, Boolean> entry : testCase.entrySet()) {

            String key = entry.getKey();
            Boolean result = entry.getValue();

            Assertions.assertEquals(result, InputValidator.checkUserInputIsValid(key),
                    "입력 요구조건을 충족하지 않음");

        }
    }

}
