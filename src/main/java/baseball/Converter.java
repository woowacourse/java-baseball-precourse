package baseball;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    // 입력값을 잘라 리스트에 넣는다.
    public static List<Integer> toList(String inputString){
        List<Integer> result = new ArrayList<>();
        for (String s : inputString.split("")) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }

    // 리스트의 요소들을 붙여 스트링 형식으로 반환한다.
    public static String toString(List<Integer> list){
        return list.toString().replaceAll("[^0-9]", "");
    }
}
