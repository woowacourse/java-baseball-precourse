package baseball;

import utils.RandomUtils;

public class AnswerGenerator {
    private static final int MIN_NUMBER = 123;
    private static final int MAX_NUMBER = 987;

    private AnswerGenerator(){
    }

    public static int generateAnswer(){
        return RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
    }
}
