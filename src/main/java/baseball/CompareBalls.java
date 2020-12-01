package baseball;

import static utils.Constant.*;

public class CompareBalls {

    public static int getStrikeCount(String computer, String player) {
        int strike = 0;
        for (int i = 0; i < BALLS_LENGTH; i++) {
            if (computer.charAt(i) == player.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    public static int getBallCount(String computer, String player) {

        int ball = 0;
        for (int i = 0; i < BALLS_LENGTH; i++) {
            if (computer.contains(String.valueOf(player.charAt(i)))) {
                ball++;
            }
        }
        return ball - getStrikeCount(computer, player);
    }

}
