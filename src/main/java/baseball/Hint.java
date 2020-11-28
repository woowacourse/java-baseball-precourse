package baseball;

import java.util.ArrayList;

public class Hint {

    private static final int NUMBER_LENGTH = 3;
    private static ArrayList<Integer> hintList = new ArrayList<>();

    public Hint(ArrayList<Integer> ballStrikeList) {
        hintList = ballStrikeList;
    }
    public static boolean hint() {
        return getHint();
    }

    public static boolean getHint() {
        if (hintList.get(0) == NUMBER_LENGTH){
            System.out.print(NUMBER_LENGTH + "스트라이크" + "\n"
                    + NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (hintList.get(0) != 0 & hintList.get(1) != 0){
            System.out.print(hintList.get(1) + "볼 " + hintList.get(0) + "스트라이크");
        }

        if (hintList.get(0) != 0 & hintList.get(1) == 0){
            System.out.print(hintList.get(0) + " 스트라이크");
        }

        if (hintList.get(0) == 0 & hintList.get(1) != 0){
            System.out.print(hintList.get(1) + "볼");
        }

        if (hintList.get(0) == 0 & hintList.get(1) == 0){
            System.out.print("낫싱");
        }

        return false;

    }

}
