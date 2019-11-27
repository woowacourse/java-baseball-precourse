import java.util.Arrays;
import java.util.Scanner;

public class Baseball {
    public static void main(String args[]) {
        int[] comNum = new int[3];
        boolean check;
        int[] userNum = new int[3];
        int num;
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
            comNum[i] = (int) (Math.random() * 9) + 1; //1~10까지 난수 생성
            check = checkOverlap(comNum[i], comNum, i);
            if(check == false) {
                i -= 1;
            }
        }

        while (true) {
            for(int i=0; i<3; i++) {
                userNum[i] = sc.nextInt();
            }
            
        }
    }

    public static boolean checkOverlap(int num, int[] comNum, int i) {
        for(int j=0; j<i; j++) {
            if(comNum[j] == num) {
                return false;
            }
        }
        return true;
    }
}