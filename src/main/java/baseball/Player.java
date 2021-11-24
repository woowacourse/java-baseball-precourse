package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Player {

    private static final int DIGIT = 3;
    private static final String PLAYER_NUMBER_REGEX = "^[1-9]{3}$";
    private static final String REPLAY_OR_END_NUMBER_REGEX = "^[1-2]$";

    public List<Integer> playerNumber() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = readLine();
        return validateInputNumber(inputNumber);
    }

    private List<Integer> validateInputNumber(String inputNumber) throws IllegalArgumentException {
        validateNumberRange(inputNumber, PLAYER_NUMBER_REGEX);
        validateNumberDuplication(inputNumber);
        return stringToIntegerList(inputNumber);
    }

    private void validateNumberRange(String inputNumber, String pattern) {
        if (!Pattern.matches(pattern, inputNumber)) {
            throw new IllegalArgumentException("정확한 값이 입력되지 않았습니다.");
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

    public int replayOrEndNumber() throws IllegalArgumentException {
        String inputNumber = readLine();
        validateNumberRange(inputNumber, REPLAY_OR_END_NUMBER_REGEX);
        return Integer.parseInt(inputNumber);
    }
}
