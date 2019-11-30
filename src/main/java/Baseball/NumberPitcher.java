package Baseball;

import Baseball.errors.InvalidInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberPitcher extends BasePlayer implements Pitcher {

    public NumberPitcher(Scanner scanner) {
        super(scanner);
    }

    @Override
    public List<Integer> pitch() {
        System.out.print("숫자를 입력주세요 : ");;
        String input = scanner.next();
        if (!isValid(input)) {
            throw new InvalidInputException("입력값이 옳바르지 않습니다.");
        }

        return translateToBalls(input);
    }

    private boolean isValid(String input) {
        // todo: change to config
        if (input.length() != 3) {
            return false;
        }

        for (char syllable: input.toCharArray()) {
            if (!Character.isDigit(syllable)) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> translateToBalls(String input) {
        List<Integer> balls = new ArrayList<>();
        for (char syllable: input.toCharArray()) {
            int ball = Character.getNumericValue(syllable);
            balls.add(ball);
        }
        return balls;
    }
}
