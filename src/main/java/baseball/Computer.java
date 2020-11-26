package baseball;

import static baseball.CheckerType.*;

import java.util.ArrayList;
import java.util.List;
import utils.RandomUtils;

public class Computer {

    private final List<Integer> numbers;

    public Computer() {
        this.numbers = new ArrayList<>();
    }

    public void generateNumber() {
        do {
            convertIntToList(RandomUtils.nextInt(123, 987), numbers);
        } while (!NumberChecker.isValidNumbers(numbers, COMPUTER));
        // System.out.println("컴퓨터의 번호가 유효함 : " + numbers.toString());
    }

    private void convertIntToList(int randomNumber, List<Integer> numbers) {
        char[] digits = convertIntToStr(randomNumber).toCharArray();
        numbers.clear();
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
}
