package baseball;
import utils.RandomUtils;

public class RandomAnswer {
    public static String randomAnswer() {
        Integer answer;

        while(true) {
            answer = RandomUtils.nextInt(100, 999);
            if (Validate.isValidate(Integer.toString(answer))) {
                return Integer.toString(answer);
            }
        }
    }
}