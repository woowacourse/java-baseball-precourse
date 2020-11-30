package baseball.service;

import baseball.domain.Number;
import baseball.domain.NumberGenerator;

public class Hint {
    NumberGenerator numberGenerator;
    Number correctNumber;
    private boolean correctSwitch;

    public Hint() {
        numberGenerator = new NumberGenerator();
    }

    public String ask(int[] userInput) {
        String hintAnswer = "";
        hintAnswer = countBall(userInput);

        /* ball이 존재하면 공백(" ") 추가 */
        if (!hintAnswer.equals("")) {
            hintAnswer += " ";
        }

        hintAnswer = hintAnswer + countStrike(userInput);

        return isNothing(hintAnswer);
    }

    private String isNothing(String hintAnswer) {
        if (hintAnswer.equals("")){
            return "낫싱";
        }

        return hintAnswer;
    }

    private String countStrike(int[] userInput) {
        int strike = 0;

        for (int i = 0; i < Number.NUM_LENGTH; i++) {
            if (correctNumber.isEquals(i, userInput[i])) {
                strike++;
            }
        }

        String strikeAnswer = "";

        if (strike > 0) {
            if (strike == Number.NUM_LENGTH) {
                correctSwitch = true;
            }
            strikeAnswer = strike + "스트라이크";
        }

        return strikeAnswer;
    }

    private String countBall(int[] userInput) {
        int ball = 0;

        for (int i=0; i<Number.NUM_LENGTH; i++) {
            if (correctNumber.containNotEquals(i, userInput[i])) {
                ball++;
            }
        }

        String ballAnswer = "";

        if (ball > 0) {
            ballAnswer = ball + "볼";
        }

        return ballAnswer;
    }

    public void createAnswer() {
        correctNumber = numberGenerator.execute();
        correctSwitch = false;
    }

    public boolean isitCorrect(){
        if (correctSwitch) {
            return true;
        }

        return false;
    }
}
