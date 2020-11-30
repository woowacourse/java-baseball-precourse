package baseball;

import java.util.ArrayList;

public class Hint {

    /*
    * ball과 strike를 이용해 hint를 제공하는 클래스
    * */
    private static final int NUMBER_LENGTH = 3;
    private static ArrayList<Integer> hintList = new ArrayList<>();

    /*
    * ballStrikeList를 가지고와서 힌트 제공하는 메서드
    * */
    public static boolean hint(ArrayList<Integer> ballStrikeList) {
        hintList = ballStrikeList;

        return getHint(hintList);
    }

    /*
     * hint를 프린트해주는 메서드
     * */
    public static boolean getHint(ArrayList<Integer> hintList) {
        if (hintList.get(1) == NUMBER_LENGTH){
            System.out.print(NUMBER_LENGTH + "스트라이크" + "\n"
                    + NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (hintList.get(0) != 0 & hintList.get(1) != 0){
            System.out.print(hintList.get(0) + "볼 " + hintList.get(1) + "스트라이크");
        }

        if (hintList.get(0) != 0 & hintList.get(1) == 0){
            System.out.print(hintList.get(0) + "볼");
        }

        if (hintList.get(0) == 0 & hintList.get(1) != 0){
            System.out.print(hintList.get(1) + "스트라이크");
        }

        if (hintList.get(0) == 0 & hintList.get(1) == 0){
            System.out.print("낫싱");
        }
        System.out.print("\n");
        return false;
    }

}
