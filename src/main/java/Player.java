import java.util.ArrayList;

public class Player {
    private ArrayList<Integer> playerNumberSet;

    public Player() {
        playerNumberSet = new ArrayList<Integer>();
    }

    public String inputNumber(String input) {
        if (input.length() != 3)
            return "3자리의 수를 입력해주세요.";
        if (!checkValidation(input))
            return "0을 제외하고 입력해주세요.";
        for (char c : input.toCharArray()) {
            playerNumberSet.add(c - '0');
        }
        return null;
    }

    private boolean checkValidation(String input) {
        for (char c : input.toCharArray()) {
            if (!(c >= 49 && c <= 57))
                return false;
        }
        return true;
    }
}
