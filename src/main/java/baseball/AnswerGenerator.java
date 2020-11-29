package baseball;

import utils.RandomUtils;
import baseball.NumberConditionChecker;

public class AnswerGenerator {
    private static final int MIN_NUMBER = 123;
    private static final int MAX_NUMBER = 987;

    private AnswerGenerator(){
    }

    public static int generateAnswer(){
        int answerCandidate;
        boolean answerError;
        do{
            answerCandidate = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
            int[] answerCandidateDigits = NumberConditionChecker.splitNumberToDigits(answerCandidate);
            answerError = NumberConditionChecker.checkZeroInList(answerCandidateDigits)
                    || NumberConditionChecker.checkOverlapNumber(answerCandidateDigits);
        } while(answerError);
        return answerCandidate;
    }
}
