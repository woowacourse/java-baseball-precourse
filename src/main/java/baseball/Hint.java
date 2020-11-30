package baseball;

import interfaces.IHint;

public class Hint implements IHint {

    private final int MAX_OF_STRIKES = 3;

    private final StringBuilder sb = new StringBuilder();

    @Override
    public String getHint(BaseballGameNumber playerNumbers, BaseballGameNumber computerNumbers) {
        sb.setLength(0);
        int numOfBalls = getNumOfBalls(playerNumbers.getNumbers(), computerNumbers.getNumbers());
        int numOfStrikes =
                getNumOfStrikes(playerNumbers.getNumbers(), computerNumbers.getNumbers());
        if (numOfBalls > 0) {
            sb.append(numOfBalls);
            sb.append("볼 ");
        }

        if (numOfStrikes > 0) {
            sb.append(numOfStrikes);
            sb.append("스트라이크");
        }

        if (numOfBalls == 0 && numOfStrikes == 0) {
            sb.append("낫싱");
        }

        return sb.toString();
    }

    private int getNumOfBalls(int[] playerNumbers, int[] computerNumbers) {
        int numOfBalls = 0;
        for (int i = 0; i < playerNumbers.length; i++) {
            if (hasNumberInComputerNumbers(computerNumbers, playerNumbers[i], i)) {
                numOfBalls++;
            }
        }
        return numOfBalls;
    }

    private boolean hasNumberInComputerNumbers(int[] computerNumbers, int num, int index) {
        for (int i = 0; i < computerNumbers.length; i++) {
            if (i != index && num == computerNumbers[i]) {
                return true;
            }
        }
        return false;
    }

    private int getNumOfStrikes(int[] playerNumbers, int[] computerNumbers) {
        int numOfStrikes = 0;
        for (int i = 0; i < playerNumbers.length; i++) {
            if (playerNumbers[i] == computerNumbers[i]) {
                numOfStrikes++;
            }
        }
        return numOfStrikes;
    }

    @Override
    public boolean isCorrectAnswer(BaseballGameNumber playerNumbers,
            BaseballGameNumber computerNumbers) {
        int numOfStrikes =
                getNumOfStrikes(playerNumbers.getNumbers(), computerNumbers.getNumbers());
        return numOfStrikes == MAX_OF_STRIKES;
    }
}
