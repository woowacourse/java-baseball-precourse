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

    public static boolean checkBall(int guess, int[] target, int index){
       for(int i=0; i < 3; i ++){
           if(i != index && guess == target[i]){
               return true;
           }
       }
       return false;
    }

    public static boolean checkReplay(int replayNum){
        if(replayNum == 1){
            return true;
        }
        else{
            return false;
        }
    }
}
