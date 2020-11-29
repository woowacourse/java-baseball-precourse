package baseball;

import java.util.Arrays;
import java.util.List;

public class GameRule {
    private int strike;
    private int ball;
    private List<String> answerWords;
    private List<String> userWords;

    public static GameRule compare(String answer, String userInput) {
        return new GameRule(answer, userInput);
    }

    private GameRule(String answer, String userInput) {
        this.answerWords = Arrays.asList(answer.split(""));
        this.userWords = Arrays.asList(userInput.split(""));
        calculateStrikeAndBall();
    }

    private void init() {
        this.strike = 0;
        this.ball = 0;
    }

    private void calculateStrikeAndBall() {
        init();
        for (int i = 0; i < answerWords.size(); i++) {
            String word = answerWords.get(i);
            if (isStrike(i, word)) {
                strike++;
            }
            if (isBall(i, word)) {
                ball++;
            }
        }
    }

    private boolean isStrike(int rightIndex, String word) {
        return userWords.contains(word) && (userWords.indexOf(word) == rightIndex);

    }

    private boolean isBall(int rightIndex, String word) {
        return userWords.contains(word) && (userWords.indexOf(word) != rightIndex);
    }

    public boolean isCollect() {
        return answerWords.equals(userWords);
    }

    public String printResult() {
        StringBuilder resultText = new StringBuilder();
        if (ball > 0) {
            resultText.append(String.format("%d볼 ", ball));
        }
        if (strike > 0) {
            resultText.append(String.format("%d스트라이크", strike));
        }
        if (strike == 0 && ball == 0) {
            resultText.append(String.format("낫싱"));
        }

        return resultText.toString();
    }

    public void changeUserInput(String userInput) {
        this.userWords = Arrays.asList(userInput.split(""));
        calculateStrikeAndBall();
    }
}
