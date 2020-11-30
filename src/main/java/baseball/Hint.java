package baseball;

import java.util.List;

public class Hint {

    private static int ball = 0;
    private static int strike = 0;
    private static final int[] result = new int[2];

    public static int[] grading(List<Integer> player, List<Integer> answer) {
        for (int i=0; i<3; i++) {
            if (player.get(i).equals(answer.get(i))) {
                strike++;
            }
            else if (answer.contains(player.get(i))) {
                ball++;
            }
        }
        result[0] = ball;
        result[1] = strike;
        return result;
    }
}
