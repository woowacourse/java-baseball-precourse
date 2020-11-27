package baseball;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.Set;

public class BaseBallNumber {

    private String answer;
    private Integer strike;
    private Integer ball;
    private Boolean isAnswer;

    public void resetNumber() {
        answer = String.valueOf(RandomUtils.nextInt(111, 999));
    }

    public void calculateMatching(String userInput) {
        strike = 0;
        ball = 0;
        isAnswer = false;

        if (answer.equals(userInput)) {
            isAnswer = true;
            return;
        }

        Set<Character> set = new HashSet<>();

        // strike 체크
        for (int i = 0; i < 3; i++) {
            if (answer.charAt(i) == userInput.charAt(i)) {
                strike++;
            } else set.add(answer.charAt(i));
        }

        // ball 체크
        for (int i = 0; i < 3; i++) {
            if (set.contains(userInput.charAt(i))) {
                ball++;
                set.remove(userInput.charAt(i));
            }
        }
    }

    public String getHint() {
        StringBuilder hints = new StringBuilder();
        if (ball > 0) hints.append(ball + "볼 ");
        if (strike > 0) hints.append(strike + "스트라이크 ");
        if (hints.length() == 0) hints.append("낫싱");
        return hints.toString();
    }

    public boolean isCorrectAnswer() {
        return isAnswer;
    }

}
