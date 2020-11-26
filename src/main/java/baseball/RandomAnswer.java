package baseball;
import utils.RandomUtils;

public class RandomAnswer {
    Integer answer;
    RandomUtils newRandomUtils = new RandomUtils();
    Validate newValidate = new Validate();

    public Integer randomAnswer() {
        while(true) {
            answer = newRandomUtils.nextInt(100, 999);
            if (newValidate.validate(answer)) {
                return answer;
            }
        }
    }

}