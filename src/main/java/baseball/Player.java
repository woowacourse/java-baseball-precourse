package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Player {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String PLAYER_NUMBER_REGEX = "^[1-9]{3}$";
    private static final String REPLAYING_OR_END_NUMBER_REGEX = "^[1-2]$";

    public List<Integer> getPlayerNumber() throws IllegalArgumentException {
        System.out.print(INPUT_MESSAGE);
        String inputNumber = readLine();
        return toIntegerList(inputNumber);
    }

    public int getReplayingOrEndNumber() throws IllegalArgumentException {
        String inputNumber = readLine();
        validateNumberRange(REPLAYING_OR_END_NUMBER_REGEX, inputNumber);
        return Integer.parseInt(inputNumber);
    }

    private List<Integer> toIntegerList(String inputNumber) throws IllegalArgumentException {
        validateInputNumber(inputNumber);
        List<String> numbers = Arrays.asList(inputNumber.split(""));
        return numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateInputNumber(String inputNumber) throws IllegalArgumentException {
        validateNumberRange(PLAYER_NUMBER_REGEX, inputNumber);
        validateNumberDuplication(inputNumber);
    }

    private void validateNumberRange(String regex, String inputNumber) {
        if (!Pattern.matches(regex, inputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberDuplication(String inputNumber) {
        HashSet<String> numbers = new HashSet<>(
                Arrays.asList(inputNumber.split(""))
        );
        if (numbers.size() != BaseBallGame.NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
