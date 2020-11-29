package baseball;

import utils.RandomUtils;

public class Game {
    private char[] answer = new char[Constants.ANSWER_LENGTH];
    
    public Game() {
    }
    
    public void generateNewAnswer() {
        StringBuilder digitPool = new StringBuilder();
        int randomIndex;
        
        initializeDigitPool(digitPool, Constants.MIN_DIGIT, Constants.MAX_DIGIT);
        
        for (int i = 0; i < Constants.ANSWER_LENGTH; i++) {
            randomIndex = RandomUtils.nextInt(0, Constants.DIGIT_POOL_SIZE - 1 - i);
            this.answer[i] = digitPool.charAt(randomIndex);
            digitPool.deleteCharAt(randomIndex);
        }
    }
    
    private void initializeDigitPool(StringBuilder digitPool,
            int lowerBound, int upperBound) {
        for (int i = lowerBound; i <= upperBound; i++) {
            digitPool.append(i);
        }
    }
}
