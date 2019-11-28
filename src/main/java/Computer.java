import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Computer {
    private List<Integer> baseballGameAnswer;

    Computer() {

    }

    public void makeBaseballGameAnswer() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < BaseballGame.MAX_NUMBER; ++i) {
            numbers.add(i + 1);
        }

        List<Integer> baseBallGameAnswer = new ArrayList<>();
        for (int j = 0; j < BaseballGame.ANSWER_NUMBERS_COUNT; ++j) {
            int randomNumber = getRandomNumber() % numbers.size();
            baseBallGameAnswer.add(randomNumber);
            numbers.remove(randomNumber);
        }

        this.baseballGameAnswer = baseBallGameAnswer;
    }



    private int getRandomNumber() {
        return (int) (Math.random() * BaseballGame.MAX_NUMBER);
    }


}
