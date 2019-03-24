import java.util.Scanner;

public class Game {
    private int strkes;
    private int balls;

    public Game(){
        this.strkes = 0;
        this.balls = 0;
    }

    public int isThereNumber(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target)
                return i;
        }
        return -1;
    }
}
