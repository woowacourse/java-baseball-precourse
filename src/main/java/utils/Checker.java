package utils;

public class Checker {
    private static boolean[] chk = new boolean[9];

    private Checker() {
    }

    public static boolean checkDuplicateNumber(int num){
        if(chk[num-1]){
            return true;
        }
        else{
            chk[num-1]=true;
            return false;
        }
    }

    public static boolean checkInput(char oneOfNumber){
        return 49 <= oneOfNumber && oneOfNumber <= 57;
    }

}
