package baseball.players.numbers;

import java.util.ArrayList;
import java.util.List;

public class UserNumbers {
    private final List<Integer> numbers;

    public UserNumbers() {
        this.numbers = new ArrayList<>();
    }

    public void convertToList(String userInput) {
        for (char number : userInput.toCharArray()) {
            checkInputError(number);
        }
    }

    private void checkInputError(char number) {
        try {
            numbers.add(Integer.parseInt(String.valueOf(number)));
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public int numberIndexOf(int index) {
        return numbers.get(index);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void clear() {
        numbers.clear();
    }
}
