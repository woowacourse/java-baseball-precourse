package baseball;

public class PrintResult {

    public static boolean validateSameNumber(int target, int num) {
        if(target == num) {
            return true;
        }
        return false;
    }

    public static boolean countBall(int[] target, int userNum) {
        for(int i=0; i<3; i++) {
            if(validateSameNumber(target[i], userNum)) {
                return true;
            }
        }
        return false;
    }

}
