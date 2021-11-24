package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Player {

    private static final int DIGIT = 3;

    public List<Integer> playerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        try {
            String inputNumber = readLine();
            return validateInputNumber(inputNumber);
        } catch (IllegalArgumentException exception) {
            exception.getMessage();
            return playerNumber();
        }
    }

    private List<Integer> validateInputNumber(String inputNumber) throws IllegalArgumentException {
        validateNumberRange(inputNumber);
        validateNumberDuplication(inputNumber);
        return stringToIntegerList(inputNumber);
    }

    private void validateNumberRange(String inputNumber) {
        String pattern = "^[1-9]{3}$";
        if (!Pattern.matches(pattern, inputNumber)) {
            throw new IllegalArgumentException("1부터 9사이의 숫자로 이루어진 3자리 수를 입력해주세요.");
        }
    }

    private void validateNumberDuplication(String inputNumber) {
        HashSet<String> numbers = new HashSet<>(
                Arrays.asList(inputNumber.split(""))
        );
        if (numbers.size() != DIGIT) {
            throw new IllegalArgumentException("중복되지 않은 3개의 숫자를 입력해주세요.");
        }
    }

    private List<Integer> stringToIntegerList(String inputNumber) {
        List<String> stringNumbers = Arrays.asList(inputNumber.split(""));
        return stringNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
