package baseball;
import utils.RandomUtils;
public class AnswerGenerator {
    public static String generateNumbers(int length){
        String answer = "";
        if (length<1) {
            throw new IllegalArgumentException();
        }
        while(length>0){
            String randomnumber = Integer.toString(RandomUtils.nextInt(1,9));
            if(!answer.contains(randomnumber)){
                answer += randomnumber;
                length -= 1;
            }
        }
        return answer;
    }
}
