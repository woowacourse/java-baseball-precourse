package baseball.domain;

import utils.Convertor;

import java.util.*;

import static baseball.config.BaseballConfiguration.BALL_LENGTH;

public class Player {
    private Set<Integer> baseballNumbers;

    public Player() {
    }

    public void inputBaseballNumbers(Scanner scanner) {
        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                baseballNumbers = Convertor.stringToIntSet(scanner.nextLine());
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
            throw new IllegalArgumentException("중복 되지 않는 3자리 수를 입력해주세요.");
        }
    }

    private void validatedBaseballRange() {
        for (Integer baseballNumber : baseballNumbers) {
            if (baseballNumber < 1 || baseballNumber > 9) {
                throw new IllegalArgumentException("입력 숫자는 1~9 사이의 숫자만 허용됩니다.");
            }
        }
    }

    public Set<Integer> getBaseballNumbers() {
        return baseballNumbers;
    }
}
