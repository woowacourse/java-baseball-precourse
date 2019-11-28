import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int rand = Create_RandomNum();
        System.out.println(rand);
        int input = input_Number();

    }

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

    private static int input_Number(){
        int input = 0;
        while(true){
            System.out.print("num: ");
            input = sc.nextInt();
            if(input >= 100 && input <= 999) {
                return input;
            }
        }
    }
}
