package baseball.players.numbers;

import baseball.checker.NumberChecker;
import java.util.ArrayList;
import java.util.List;
import utils.RandomUtils;

public class ComputerNumbers {
    private static final int GAME_MIN_NUMBER = 123;
    private static final int GAME_MAX_NUMBER = 987;
    private final List<Integer> numbers;

    public ComputerNumbers() {
        this.numbers = new ArrayList<>();
    }

    public void generateNumber() {
        do {
            this.clear();
            convertIntToList(RandomUtils.nextInt(GAME_MIN_NUMBER, GAME_MAX_NUMBER));
        } while (!isAllowedNumbers(numbers));
    }

    private boolean isAllowedNumbers(List<Integer> numbers) {
        try {
            NumberChecker.checkNumbers(numbers);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public void convertIntToList(int randomNumber) {
        char[] digits = convertIntToStr(randomNumber).toCharArray();
        for (char digit : digits) {
            numbers.add(Integer.parseInt(Character.toString(digit)));
        }
    }

    private String convertIntToStr(int randomNumber) {
        return String.valueOf(randomNumber);
    }

    public void clear() {
        numbers.clear();
    }

    public int getNumberIndexOf(int index) {
        return numbers.get(index);
    }

    public void checkNumbers() {
        NumberChecker.checkNumbers(numbers);
    }
}
