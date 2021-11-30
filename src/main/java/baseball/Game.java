package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private String computerNumber;

    Game(String computerNumber) {
        this.computerNumber = computerNumber;
    }

    public static String getRandomValue() {
        StringBuilder sb = new StringBuilder();

        while (sb.length() != 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!sb.toString().contains(randomNumber)) {
                sb.append(randomNumber);
            }
        }
        return sb.toString();
    }
}