package GameMake;

import java.util.Random;
import java.util.Scanner;

public class Baseball {
    private static int[] ans = new int[3];
    private static int[] input = new int[3];

    public Baseball(){
        Random rand = new Random();
        for(int i=0;i<ans.length;i++) {
            ans[i] = rand.nextInt(9)+1; // 1 ~ 9 난수생성
        }
//        for(int i=0;i<ans.length;i++) {
//            System.out.print(ans[i]);
//        }
    }
}
