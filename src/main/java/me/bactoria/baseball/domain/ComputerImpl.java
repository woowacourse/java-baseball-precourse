package me.bactoria.baseball.domain;

import me.bactoria.baseball.Constant;
import me.bactoria.baseball.utils.IntegerUtils;

public class ComputerImpl implements Computer {

    private final int answerNumber;

    public ComputerImpl() {
        this.answerNumber = generateEachDifferentRandomNumber(Constant.NUMBER_OF_DIGITS);
    }

    @Override
    public String getHint(int guessNumber) {
        Hint hint = new Hint() {
            @Override
            public String getHint() {
                return "낫싱";
            }
        };
        return hint.getHint();
    }

    @Override
    public boolean isAnswer(int guessNumber) {
        return answerNumber == guessNumber;
    }

    private int generateEachDifferentRandomNumber(int digits) {
        while (true) {
            int randomNumber = (int) (Math.random() * (int) Math.pow(10, digits));
            if (IntegerUtils.isEachDigitUnique(randomNumber)
                    && !IntegerUtils.containZero(randomNumber)) {
                return randomNumber;
            }
        }
    }

}
