package baseball;

import utils.RandomUtils;

public class AnswerGenerator {
    private static final int MIN_NUMBER = 123;
    private static final int MAX_NUMBER = 987;

    private AnswerGenerator(){
    }

    public static int generateAnswer(){
        int answerCandidate;
        boolean suitability;
        do{
            answerCandidate = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
            suitability = NumberConditionChecker.checkNumberCondition(answerCandidate);
        } while(!suitability);
        return answerCandidate;
    }
}
