package baseball;

public class PrintResult {

    public static int countStrike(int[] target, int[] userNum) {
        int strike = 0;

        for(int i=0; i<3; i++) {
            if (target[i] == userNum[i]) {
                strike++;
            }
        }

        return strike;
    }

    public static boolean countBall(int[] target, int userNum, int userIndex) {
        for(int i=0; i<3; i++) {
            if(i != userIndex && target[i] == userNum) {
                return true;
            }
        }
        return false;
    }


}
