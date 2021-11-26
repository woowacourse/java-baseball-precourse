package baseball;

public class PrintResult {

    public static boolean strike(int target, int userNum) {
        if(target == userNum) {
            return true;
        }
        return false;
    }

    public static boolean ball(int[] target, int userNum, int userIndex) {
        for(int i=0; i<3; i++) {
            if(i != userIndex && target[i] == userNum) {
                return true;
            }
        }
        return false;
    }

    public static int[] countResult(int[] target, int[] userNum) {
        int strike = 0;
        int ball = 0;

        for(int i=0; i<3; i++) {
            if(strike(target[i], userNum[i])) {
                strike++;
            } else if(ball(target, userNum[i], i)) {
                ball++;
            }
        }

        int[] result = {strike, ball};

        return result;
    }

}
