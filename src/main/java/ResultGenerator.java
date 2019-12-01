/**
 * ResultGenerator 클래스에서는 NumberComparer 클래스에서 만들어진 ball, strike의 수를 바탕으로 게임의 결과를 출력하고 종료 여부를 반환한다.
 */

import java.util.ArrayList;

public class ResultGenerator {
    private static ArrayList<Integer> resultList = new ArrayList<>();
    private static final int NUMBER_LENGTH = 3;

    public static boolean resultGenerator(ArrayList<Integer> inputList) {
        resultList = inputList;
        return getResult();
    }

    public static boolean getResult() {
        if (resultList.get(1) == NUMBER_LENGTH) {
            System.out.println(NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (resultList.get(1) != 0) {
            System.out.print(resultList.get(1) + " 스트라이크 ");
        }

        if (resultList.get(2) != 0) {
            System.out.print(resultList.get(2) + " 볼 ");
        }

        if (resultList.get(1) == 0 && resultList.get(2) == 0) {
            System.out.print(NUMBER_LENGTH + "개의 숫자를 다 틀렸습니다.");
        }
        System.out.print("\n");
        return false;
    }

}
