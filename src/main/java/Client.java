import java.util.ArrayList;
import java.util.List;

public class Client {

    static final int baseballGameSize = 3;
    static final int nowAllowedInteger  = 0;

    public List<Integer> makeNumbersFromString(String inputFromUser) {
        checkValidation(inputFromUser);
        return convertToNumbers(inputFromUser);
    }

    private boolean checkValidation(String inputFromUser) {
        return checkLength(inputFromUser) && checkAllNumbers(inputFromUser) && checkNoZeroNumber(inputFromUser) && checkNoDuplication(inputFromUser);
    }

    private boolean checkLength(String inputFromUser) {
        if ( inputFromUser.length() != baseballGameSize ) {
            throw new RuntimeException();
        }
        return true;
    }

    private boolean checkAllNumbers(String inputFromUser) {
        try {
            Integer.parseInt(inputFromUser);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
        return true;
    }

    private boolean checkNoZeroNumber(String inputFromUser) {
        for (int i = 0; i < inputFromUser.length(); i++) {
            if (Integer.parseInt(String.valueOf(inputFromUser.charAt(i))) == nowAllowedInteger) {
                throw new RuntimeException();
            }
        }
        return true;
    }

    private boolean checkNoDuplication(String inputFromUser) {
        if (inputFromUser.chars().distinct().count() != inputFromUser.length() ) {
            throw new RuntimeException();
        }
        return true;
    }

    private List<Integer> convertToNumbers(String inputFromUser) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputFromUser.length(); i++) {
            numbers.add(Integer.parseInt(String.valueOf(inputFromUser.charAt(i))));
        }
        return numbers;
    }

}
