package baseball.domain;

import baseball.view.GameView;
import utils.Convertor;

import java.util.*;

import static baseball.config.BaseballConfiguration.*;
import static baseball.view.IllegalArgumentExceptionView.INPUT_NOT_DUPLICATED_THREE_DIGIT_NUMBERS;
import static baseball.view.IllegalArgumentExceptionView.INPUT_OUT_OF_RANGE_NUMBER;

public class Player {
    private List<Integer> baseballNumbers;

    public Player() {
    }

    public void inputBaseballNumbers(Scanner scanner) {
        while (true) {
            baseballNumbers = Convertor.stringToIntList(GameView.inputNumbers(scanner));
            try {
                validateBaseballNumbers();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBaseballNumbers() {
        validatedBaseballLength();
        validatedBaseballRange();
    }

    private void validatedBaseballLength() {
        if (baseballNumbers.size() != BALL_LENGTH) {
            throw new IllegalArgumentException(INPUT_NOT_DUPLICATED_THREE_DIGIT_NUMBERS);
        }
    }

    private void validatedBaseballRange() {
        for (Integer baseballNumber : baseballNumbers) {
            if (baseballNumber < START_INCLUSIVE || baseballNumber > END_INCLUSIVE) {
                throw new IllegalArgumentException(INPUT_OUT_OF_RANGE_NUMBER);
            }
        }
    }

    public List<Integer> getBaseballNumbers() {
        return baseballNumbers;
    }
}
