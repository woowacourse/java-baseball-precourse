package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Number {
    private static List<Integer> randomNumber = new ArrayList<>();
    private static Integer continueOrNot;
    private static Integer strike;
    private static Integer ball;
    private static Integer num;

    private static void getRandomNumber() {
        while (randomNumber.size() < 3) {
            num = Randoms.pickNumberInRange(1, 9);
            numberDuplication(num);
        }
    }

    public static void numberDuplication(Integer num) {
        if (!randomNumber.contains(num)) {
            randomNumber.add(num);
        }
    }




    public static void start() {
        getRandomNumber();
        BaseBallPlayer baseBallPlayer = new BaseBallPlayer();
        BaseBallPlayer.getUserNumber();
    }
}
