package baseball;

import java.util.HashSet;
import java.util.Set;

public class Player {


    /*
    player 3자리수 입력 유효성 검사 메소드
    - 숫자, 3자리수, 1~9범위, 중복 체크
    */
    public void validate3Digits(String playerNumber) {
        try{
            Integer.parseInt(playerNumber);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if(playerNumber.length()!=3 || playerNumber.contains("0")) {
            throw new IllegalArgumentException();
        }

        Set<String> set = new HashSet<>();
        for(String data : playerNumber.split("")) {
            set.add(data);
        }
        if(set.size()!=3) {
            throw new IllegalArgumentException();
        }
    }

    /* player 종료여부 입력 유효성 검사 메소드 */
    public static void validateDigit(String playerInput) {
        try{
            Integer.parseInt(playerInput);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        Set<String> validInputSet = new HashSet<>();
        validInputSet.add("1");
        validInputSet.add("2");

        if(!validInputSet.contains(playerInput)) {
            throw new IllegalArgumentException();
        }
    }
}
