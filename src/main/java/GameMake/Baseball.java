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
    public int check(){
        int strike = 0;
        int ball = 0;

        if(ans[0]==input[0])
            strike++;
        if(ans[1]==input[1])
            strike++;
        if(ans[2]==input[2])
            strike++;

        if(ans[0]==input[1]||ans[0]==input[2])
            ball++;
        if(ans[1]==input[0]||ans[1]==input[2])
            ball++;
        if(ans[2]==input[0]||ans[2]==input[1])
            ball++;
        System.out.println(strike + "스트라이크" + ball + "볼");

        return strike;
    }
}
