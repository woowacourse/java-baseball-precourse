package baseball;

import utils.RandomUtils;

public class Game {
    private char[] answer = new char[Constants.ANSWER_LENGTH];
    
    public Game() {
    }
    
    public void generateNewAnswer() {
        StringBuilder digitPool = generateDigitPool();
        int randomIndex;
        
        for (int i = 0; i < Constants.ANSWER_LENGTH; i++) {
            randomIndex = RandomUtils.nextInt(0, Constants.DIGIT_POOL_SIZE - 1 - i);
            this.answer[i] = digitPool.charAt(randomIndex);
            digitPool.deleteCharAt(randomIndex);
        }
    }
    
    private StringBuilder generateDigitPool() {
        StringBuilder digitPool = new StringBuilder();
        
        for (int i = Constants.MIN_DIGIT; i <= Constants.MAX_DIGIT; i++) {
            digitPool.append(i);
        }
        
        return digitPool;
    }
}
