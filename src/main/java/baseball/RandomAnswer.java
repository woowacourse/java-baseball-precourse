package baseball;
import utils.RandomUtils;

public class RandomAnswer {

    public static final int MODE_ANSWER_GENERATE = 2;

    public static String randomAnswer() {
        Integer answer;

        while(true) {
            answer = RandomUtils.nextInt(100, 999);
            if (Validate.isValidate(Integer.toString(answer), MODE_ANSWER_GENERATE)) {
                return Integer.toString(answer);
            }
        }
    }
}