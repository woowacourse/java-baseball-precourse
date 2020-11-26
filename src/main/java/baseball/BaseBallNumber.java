package baseball;

import utils.RandomUtils;

public class BaseBallNumber {

    private String answer;
    private Integer strike;
    private Integer ball;
    private Boolean isAnswer;
    private boolean[] isChecked;

    public void resetNumber() {
        answer = String.valueOf(RandomUtils.nextInt(111, 999));
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
