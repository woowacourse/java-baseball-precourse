package me.bactoria.baseball.domain;

import me.bactoria.baseball.Constant;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ComputerImpl implements Computer {

    private final int answerNumber;

    public ComputerImpl() {
        this.answerNumber = generateEachDifferentRandomNumber(Constant.NUMBER_OF_DIGITS);
    }

    @Override
    public String getHint(int guessNumber) {
        Hint hint = new Hint(answerNumber, guessNumber);
        return hint.getHint();
    }

    @Override
    public boolean isAnswer(int guessNumber) {
        return answerNumber == guessNumber;
    }

    private int generateEachDifferentRandomNumber(int digits) {
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        StringBuilder result = new StringBuilder();

        while (digits-- > 0) {
            int idx = (int) (Math.random() * list.size());
            result.append(list.get(idx));
            list.remove(idx);
        }

        return Integer.parseInt(result.toString());
    }

}
