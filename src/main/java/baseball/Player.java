package baseball;

import java.util.HashSet;
import java.util.Set;

public class Player {

    /*
    player 3자리수 입력 유효성 검사 메소드
    - 숫자, 3자리수, 1~9범위, 중복 체크
    */
    public void digitsValidate(String playerNumber) {
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

}
