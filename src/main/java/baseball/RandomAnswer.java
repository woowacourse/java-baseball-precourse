package baseball;
import utils.RandomUtils;

public class RandomAnswer {
    public static Integer randomAnswer() {
        Integer answer;

        while(true) {
            answer = RandomUtils.nextInt(100, 999);
            if (Validate.validate(answer)) {
                return answer;
            }
        }
    }

}