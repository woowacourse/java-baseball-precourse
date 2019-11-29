package GameMake;

import java.util.Random;

public class Baseball {
    private static int[] ans = new int[3];

    public static void makeAns(){
        Random rand = new Random();
        for(int i=0;i<ans.length;i++) {
            ans[i] = rand.nextInt(9)+1; // 1 ~ 9 난수생성
        }
    }
}
