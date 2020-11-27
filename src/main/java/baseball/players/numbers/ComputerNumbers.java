package baseball.players.numbers;

import static baseball.checker.types.CheckerType.COMPUTER;

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
        } while (!NumberChecker.isValidNumbers(numbers, COMPUTER));
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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void clear() {
        numbers.clear();
    }

    public int numberIndexOf(int index) {
        return numbers.get(index);
    }
}
