import java.util.*;

public class Computer {
    public int[] answer = new int[3];

    public void getRandom(){
        Random r = new Random();
        
        int i = 0;
        while(i < 3){
            int n = r.nextInt(8) + 1;
            if(checkRandom(n, i)){
                answer[i++] = n;
            }
        }
    }

    public boolean checkRandom(int n, int length){
        for(int i = 0; i < length; i++){
            if(answer[i] == n){
                return false;
            }
        }
        return true;
    }

    public void showAnswer(){
        System.out.println(answer[0] + "" + answer[1] + "" + answer[2]);
    }
}