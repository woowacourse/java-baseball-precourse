package baseball;

import static utils.TextResource.*;

public class BaseBallGame {
    private BaseBallGameNumber answer = null;

    public BaseBallGame(BaseBallGameNumber answer) {
        this.answer = answer;
    }


    public boolean checkInputNumber(String inputNumber) {
        makeHint(inputNumber);
        if (answer.getNumber().equals(inputNumber)) {
            System.out.println(STATEMENT_INPUT_ANSWER);
            return true;
        }
        return false;
    }

    private void makeHint(String inputNumber) {
        int ball = 0, strike = 0;
        for (int i = 0; i < inputNumber.length(); i++) {
            if (answer.getNumber().charAt(i) == inputNumber.charAt(i)) {
                strike++;
                continue;
            }

            if (answer.getNumber().contains(inputNumber.substring(i, i + 1))) {
                ball++;
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
