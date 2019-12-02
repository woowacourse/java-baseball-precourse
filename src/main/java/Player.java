import java.util.ArrayList;

/**
 * 사용자 클래스. 사용자가 입력한 수의 유효성을 검사한다.
 * @author giantim
 */
public class Player {
	/** 사용자가 입력한 수를 저장하는 배열 */
    private ArrayList<Integer> playerNumberSet;
    
    /**
     * 생성자.
     */
    public Player() {
        playerNumberSet = new ArrayList<Integer>();
    }
    
    /**
     * 게임을 시작하고 사용자가 입력한 수의 입력 형식을 검사한다.
     * 입력 형식 검사 항목은 0 또는 숫자 이외의 문자가 포함되어있는지 검사한다.
     * 입력값의 길이가 3인지 검사한다.
     * 서로 다른 수를 입력했는지를 검사한다.
     * @param input 사용자가 입력한 값.
     * @return 오류 메세지를 반환한다. 공백 문자열은 다음 단계로 진행한다.
     */
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
    
    /**
     * 사용자가 입력한 값에 0 또는 숫자가 아닌 다른 값이 포함되어 있는지 검사한다.
     * @param input 사용자의 입력값.
     * @return false 사용자의 입력값에 1~9 이외의 값이 포함되어 있음.
     * @return true 사용자가 유효한 값을 입력했음.
     */
    private boolean checkContainZero(String input) {
        for (char c : input.toCharArray()) {
            if (!(c >= Constant.ASCII_ONE && c <= Constant.ASCII_NINE))
                return false;
        }
        return true;
    }
    
    /**
     * 사용자가 입력한 숫자가 서로 다른 수로 이루어져 있는지 검사한다.
     * @param input 사용자의 입력값.
     * @return false 사용자의 입력값에 중복되는 수가 존재한다.
     * @return true 사용자의 입력값이 중복되지 않는 수로 이루어져 있다.
     */
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
    
    /**
     * private으로 선언된 사용자가 입력한 수 배열을 반환한다.
     * @return 사용자가 입력한 수 배열.
     */
    public ArrayList<Integer> getNumberSet() {
        return playerNumberSet;
    }
}
