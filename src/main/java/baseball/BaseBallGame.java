package baseball;

import static utils.TextResource.*;

public class BaseBallGame {
    private String answer = null;

    public BaseBallGame(String answer) {
        this.answer = answer;
    }
    
    private void checkHint(String inputNumber) {
        int ball = 0, strike = 0;
        for (int i = 0; i < inputNumber.length(); i++) {
            if (answer.charAt(i) == inputNumber.charAt(i)) {
                strike++;
                continue;
            }

            if (answer.contains(inputNumber.substring(i, i + 1))) {
                ball++;
                continue;
            }
        }
        printHint(ball, strike);
    }

    private void printHint(int ball, int strike) {
        if (ball <= 0 && strike <= 0) {
            System.out.println(HINT_NOTHING);
            return;
        }

        StringBuilder hint = new StringBuilder();
        if (ball > 0) {
            hint.append(ball + HINT_BALL);
            hint.append(" ");
        }

        if (strike > 0) {
            hint.append(strike + HINT_STRIKE);
        }

        System.out.println(hint.toString());
    }
}
