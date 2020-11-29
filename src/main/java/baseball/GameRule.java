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

    public void printResult() {
        if (ball > 0) {
            System.out.printf("%d볼 ", ball);
        }
        if (strike > 0) {
            System.out.printf("%d스트라이크", strike);
        }
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public void changeUserInput(String userInput) {
        this.userWords = Arrays.asList(userInput.split(""));
        calculateStrikeAndBall();
    }
}
