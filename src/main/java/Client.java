import java.util.ArrayList;
import java.util.List;

public class Client {

    private static final int COUNT_SHOULD_BE_MATCHED = 3;
    private static final int NOT_ALLOWED_INTEGER = 0;

    public List<Integer> makeNumbersFromString(String inputFromUser) {
        validates(inputFromUser);
        return convertToNumbers(inputFromUser);
    }

    private boolean validates(String inputFromUser) {
        return checkLength(inputFromUser) && checkAllNumbers(inputFromUser) &&
                checkNoZeroNumber(inputFromUser) && checkNoDuplication(inputFromUser);
    }

    private boolean checkLength(String inputFromUser) {
        if (inputFromUser.length() != COUNT_SHOULD_BE_MATCHED) {
            throw new InvalidInputException("입력하신 문자의 길이가 " + COUNT_SHOULD_BE_MATCHED + "이 아닙니다.");
        }
        return true;
    }

    private boolean checkAllNumbers(String inputFromUser) {
        try {
            Integer.parseInt(inputFromUser);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("입력하신 문자 중 숫자가 아닌 문자가 포함되어 있습니다.");
        }
        return true;
    }

    private boolean checkNoZeroNumber(String inputFromUser) {
        for (int i = 0; i < inputFromUser.length(); i++) {
            if (convertFromCharToInt(inputFromUser.charAt(i)) == NOT_ALLOWED_INTEGER) {
                throw new InvalidInputException("입력하신 문자 중 " + NOT_ALLOWED_INTEGER + "(이)가 포함되어 있습니다.");
            }
        }
        return true;
    }

    private boolean checkNoDuplication(String inputFromUser) {
        if (inputFromUser.chars().distinct().count() != inputFromUser.length()) {
            throw new InvalidInputException("입력하신 숫자 중 중복된 수가 존재합니다.");
        }
        return true;
    }

    private List<Integer> convertToNumbers(String inputFromUser) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputFromUser.length(); i++) {
            numbers.add(convertFromCharToInt(inputFromUser.charAt(i)));
        }
        return numbers;
    }

    private int convertFromCharToInt(char number) {
        return Character.getNumericValue(number);
    }
}
