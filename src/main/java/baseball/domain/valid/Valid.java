package baseball.domain.valid;

import java.util.HashMap;
import java.util.Map;

public interface Valid {
    // 입력된 숫자 내에 중복되는 숫자들이 있는지 확인한다.
    default boolean duplicate(String input) {
        // 중복을 확인하기 위해 Map 자료구조를 활용한다.
        Map<Character, Integer> map = new HashMap<>();

        for(char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Map 자료구조에서 key 의 개수가 3개가 아니면 중복이 된것이다.
        if( map.keySet().size() != 3)
            return true;
        return false;
    }

    // 입력된 숫자가 3자리 수 범위 내에 있는지 확인한다.
    default boolean inRange(String input) {
        int num = Integer.parseInt(input);
        if(num < 100 || num > 999)
            return false;
        return true;
    }

    // 입력된 숫자에 0이 포함되어 있는지 확인한다.
    default boolean hasZero(String input) {
        if(input.indexOf('0') != -1)
            return true;
        return false;
    }

}
