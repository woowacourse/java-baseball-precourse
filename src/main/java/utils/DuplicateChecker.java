package utils;

public class DuplicateChecker {
    private static boolean[] chk = new boolean[9];

    private DuplicateChecker() {
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
}
