package baseball;
import utils.RandomUtils;
public class AnswerGenerator {
    public static String generateNumbers(int length) {
        String answer = "";
        if (length < 1) {
            throw new IllegalArgumentException();
        }
        while (length > 0) {
            String randomNumber = Integer.toString(RandomUtils.nextInt(1,9));
            if (!answer.contains(randomNumber)) {
                answer += randomNumber;
                length -= 1;
            }
        }
        return answer;
    }
}
