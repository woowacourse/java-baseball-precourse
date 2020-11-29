package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballResultPrint {
    public static void resultPrint(List<Integer> result) {
        List<Integer> resultList = new ArrayList<>(result);

        if (1 <= resultList.get(0) && 1 <= resultList.get(1)) {
            System.out.println(String.format("%d볼 %d스트라이크 입니다.", resultList.get(0), resultList.get(1)));
        } else if (1 <= resultList.get(0) && resultList.get(1) == 0) {
            System.out.println(resultList.get(0) + "볼 입니다.");
        } else if (0 == resultList.get(0) && resultList.get(1) == 1) {
            System.out.println(resultList.get(1) + "스트라이크 입니다.");
        } else if (0 == resultList.get(0) && resultList.get(1) == 2) {
            System.out.println(resultList.get(1) + "스트라이크 입니다.");
        } else if (resultList.get(1) == 3) {
            System.out.println(resultList.get(1) + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            System.out.println("낫싱");
        }
    }
}
