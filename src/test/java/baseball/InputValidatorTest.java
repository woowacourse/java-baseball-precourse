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

    @Test
    public void checkExitCommandIsValidTest() {
        String[] arrTrue = new String[] {"1", "2"};
        String[] arrFalse = new String[] {"0", "3", "A"};

        for (String element : arrTrue){
            Assertions.assertTrue(InputValidator.checkExitCommandIsValid(element),
                    "유효하지 않은 잘못된 커맨드입니다");
        }
        for (String element : arrFalse){
            Assertions.assertTrue(InputValidator.checkExitCommandIsValid(element),
                    "유효하지 않은 잘못된 커맨드입니다");
        }
    }

}
