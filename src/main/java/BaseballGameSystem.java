public class BaseballGameSystem {
    private int answerNumber;

    BaseballGameSystem() {
        answerNumber = generateRandomNumber();
    }

    public int generateRandomNumber() {
        final int DIGIT = 3;
        int randomNumber = 0;
        int adder = 1;

        for (int i = 0; i < DIGIT; i++) {
            randomNumber += (int) ((Math.random() * 9) + 1) * adder;
            adder *= 10;
        }

        return randomNumber;
    }

    public void checkAnswer(int userNumber) {}

    public void finishGame(int nextStep) {}

    public void startNewGame(int nextStep) {}
}
