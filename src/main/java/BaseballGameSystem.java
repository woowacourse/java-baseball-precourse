import java.util.HashSet;

public class BaseballGameSystem {
    private static final int DIGIT = 3;
    private HashSet<Integer> answerNumberSet = new HashSet<>();

    BaseballGameSystem() {
        while (answerNumberSet.size() < DIGIT) {
            answerNumberSet.add(generateRandomNumber());
        }
    }

    public int generateRandomNumber() {
        return (int) ((Math.random() * 9) + 1);
    }

    public void checkAnswer(int userNumber) {}

    public void finishGame(int nextStep) {}

    public void startNewGame(int nextStep) {}
}
