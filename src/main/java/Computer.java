import java.util.ArrayList;
import java.util.List;

class Computer {


    private List<Integer> baseballGameAnswer;

    Computer() {

    }

    public void makeBaseballGameAnswer() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> baseBallGameAnswer = new ArrayList<>();

        for (int i = 0; i < BaseballGame.MAX_NUMBER; ++i) {
            numbers.add(i + 1);
        }

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

    public void printHintMessage(List<Integer> playerInputNumbers) {
        int strikeCount = getStrikeCount(playerInputNumbers);
        int ballCount = getBallCount(playerInputNumbers);

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            return;
        }

        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크 ");
        }

        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }

        System.out.println();
    }

    private int getStrikeCount(List<Integer> playerInputNumbers) {
        int strikeCount = 0;

        for (int index = 0; index < BaseballGame.ANSWER_NUMBERS_COUNT; ++index) {
            if (baseballGameAnswer.get(index).equals(playerInputNumbers.get(index))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private int getBallCount(List<Integer> playerInputNumbers) {
        int ballCount = 0;

        for (int number : playerInputNumbers) {
            if (hasNumberInAnswer(number)) {
                ballCount++;
            }
        }

        for (int index = 0; index < BaseballGame.ANSWER_NUMBERS_COUNT; ++index) {
            if (baseballGameAnswer.get(index).equals(playerInputNumbers.get(index))) {
                ballCount--;
            }
        }

        return ballCount;
    }

    private boolean hasNumberInAnswer(int number) {
        return this.baseballGameAnswer.contains(number);
    }
}
