package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameRole {

    public static void startGame() {
        while (true) {
            InputRole inputRole = new InputRole();
            String a = inputRole.getInputValue();
            System.out.println("getRandomNumber() = " + getRandomNumber());
            return;
        }
    }

    public static String getRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return numbers.toString().replaceAll("[^0-9]", "");
    }


}
