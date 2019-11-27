import java.util.ArrayList;
import java.util.List;

class Computer {
    private static final int MAX_NUMBER = 9;
    private static final int ANSWER_NUMBERS_COUNT = 3;
    private List<Integer> baseballGameAnswer;

    Computer() {

    }

    public void makeBaseballGameAnswer() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < MAX_NUMBER; ++i) {
            numbers.add(i + 1);
        }

        List<Integer> baseBallGameAnswer = new ArrayList<>();
        for (int j = 0; j < ANSWER_NUMBERS_COUNT; ++j) {
            int randomNumber = getRandomNumber() % numbers.size();
            baseBallGameAnswer.add(randomNumber);
            numbers.remove(randomNumber);
        }

        this.baseballGameAnswer = baseBallGameAnswer;
    }

    private int getRandomNumber() {
        return (int) (Math.random() * MAX_NUMBER);
    }


}
