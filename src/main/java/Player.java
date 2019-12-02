import java.util.ArrayList;

public class Player {
    private ArrayList<Integer> playerNumberSet;

    public Player() {
        playerNumberSet = new ArrayList<Integer>();
    }

    public String inputNumber(String input) {
    	if (!checkContainZero(input))
            return Constant.STR_ZERO_EXCEPT;
    	if (input.length() != Constant.NUM_SIZE)
            return Constant.STR_LENGTH_THREE;
        if (!checkValidation(input))
            return Constant.STR_EACH_DIFF_NUM;
        playerNumberSet.clear();
        for (char c : input.toCharArray()) {
            playerNumberSet.add(c - Constant.CHAR_ZERO);
        }
        return Constant.STR_EMPTY;
    }

    private boolean checkContainZero(String input) {
        for (char c : input.toCharArray()) {
            if (!(c >= Constant.ASCII_ONE && c <= Constant.ASCII_NINE))
                return false;
        }
        return true;
    }

    private boolean checkValidation(String input) {
        ArrayList<Boolean> checkList = new ArrayList<Boolean>();

        for (int i = 0; i < Constant.CHECKLIST_SIZE; i++) {
            checkList.add(false);
        }
        checkList.set(input.charAt(0) - Constant.CHAR_ZERO, true);
        for (int i = 1; i < input.length(); i++) {
            if (checkList.get(input.charAt(i) - Constant.CHAR_ZERO).equals(true)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> getNumberSet() {
        return playerNumberSet;
    }
}
