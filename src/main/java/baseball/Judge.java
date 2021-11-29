package baseball;

public class Judge {
    public static boolean IsBall(String rightAnswer, char num, int idx){
        for (int i=0; i<rightAnswer.length(); i++) {
            if (i == idx) {
                continue;
            }
            if (rightAnswer.charAt(idx) == num) {
                return true;
            }
        }
        return false;
    }
    public static boolean IsStrike(String rightAnswer, char num, int idx){
        if (rightAnswer.charAt(idx) == num) {
            return true;
        }
        return false;
    }
}
