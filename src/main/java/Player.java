import java.util.ArrayList;

public class Player {
    private ArrayList<Integer> playerNumberSet;

    public Player() {
        playerNumberSet = new ArrayList<Integer>();
    }

    public String inputNumber(String input) {
        if (input.length() != 3)
            return "3자리의 수를 입력해주세요.";
        if (!checkContainZero(input))
            return "0을 제외하고 입력해주세요.";
        if (!checkValidation(input))
            return "서로 다른 수로 이루어진 3자리 수를 입력해주세요.";
        playerNumberSet.clear();
        for (char c : input.toCharArray()) {
            playerNumberSet.add(c - '0');
        }
        return "";
    }

    private boolean checkContainZero(String input) {
        for (char c : input.toCharArray()) {
            if (!(c >= 49 && c <= 57))
                return false;
        }
        return true;
    }

    private boolean checkValidation(String input) {
        ArrayList<Boolean> checkList = new ArrayList<Boolean>();

        for (int i = 0; i < 10; i++) {
            checkList.add(false);
        }
        checkList.set(input.charAt(0) - '0', true);
        for (int i = 1; i < input.length(); i++) {
            if (checkList.get(input.charAt(i) - '0').equals(true)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> getNumberSet() {
        return playerNumberSet;
    }
}
