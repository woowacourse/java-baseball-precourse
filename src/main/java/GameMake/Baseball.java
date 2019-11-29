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
    public void makeInput(){
        System.out.flush();
        System.out.print("숫자를 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);

        int temp;
        temp = sc.nextInt();
        sc.nextLine();

        for(int i=(input.length-1);i>=0;i--){
            input[i] = temp%10;
            temp/=10;
        }
//        for(int i=0;i<ans.length;i++) {
//            System.out.print(input[i]);
//        }
    }
}
