package baseball;

import java.util.HashSet;
import utils.RandomUtils;

public class Game {
    private char[] answer = new char[Constants.ANSWER_LENGTH];
    private HashSet<Character> answerSet = new HashSet<>();
    
    public Game() {
    }
    
    public void generateNewAnswer() {
        StringBuilder digitPool = new StringBuilder();
        int randomIndex;
        
        answerSet.clear();
        initializeDigitPool(digitPool, Constants.MIN_DIGIT, Constants.MAX_DIGIT);
        
        for (int i = 0; i < Constants.ANSWER_LENGTH; i++) {
            randomIndex = RandomUtils.nextInt(0, Constants.DIGIT_POOL_SIZE - 1 - i);
            this.answer[i] = digitPool.charAt(randomIndex);
            this.answerSet.add(digitPool.charAt(randomIndex));
            digitPool.deleteCharAt(randomIndex);
        }
    }
    
    public BallCount judge(char[] guess) {
        BallCount ballCount = new BallCount();
        
        for (int i = 0; i < Constants.ANSWER_LENGTH; i++) {
            if (this.answer[i] == guess[i]) {
                ballCount.setStrike(ballCount.getStrike() + 1);
            } else if (this.answerSet.contains(guess[i])) {
                ballCount.setBall(ballCount.getBall() + 1);
            }
        }
        
        return ballCount;
    }
    
    private void initializeDigitPool(StringBuilder digitPool,
            int lowerBound, int upperBound) {
        for (int i = lowerBound; i <= upperBound; i++) {
            digitPool.append(i);
        }
    }
}
