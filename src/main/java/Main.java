import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
    }

    //RandomNumber 생성기
    private static int Create_RandomNum(){
        Random random = new Random();
        int randNum = 0;
        boolean[] number = new boolean[10];
        int it = 0;
        while(it<3){
            int x = random.nextInt(9)+1;
            if(number[x]) continue;
            number[x] = true;
            randNum += x*Math.pow(10,it);
            it++;
        }

        return randNum;
    }
}
