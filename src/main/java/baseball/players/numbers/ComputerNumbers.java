package baseball.players.numbers;

import static baseball.checker.CheckerType.COMPUTER;

import baseball.checker.NumberChecker;
import java.util.ArrayList;
import java.util.List;
import utils.RandomUtils;

public class ComputerNumbers {
    private final List<Integer> numbers;

    public ComputerNumbers() {
        this.numbers = new ArrayList<>();
    }

    public void generateNumber() {
        do {
            this.clear();
            convertIntToList(RandomUtils.nextInt(123, 987));
        } while (!NumberChecker.isValidNumbers(numbers, COMPUTER));
        // System.out.println("컴퓨터의 번호가 유효함 : " + numbers.toString());
    }

    private void convertIntToList(int randomNumber) {
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
}
