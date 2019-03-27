import java.util.Random;
import java.util.Scanner;
public class baseball {
    public static void RandomSave(int[] num) {
        Random random = new Random();
        for (int i = 0; i < 3; i++)
            num[i] = random.nextInt(10)+1;
    }

    public static int UserInput(){
        int us_input;
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        us_input = sc.nextInt();
        return us_input;
    }

    public static void main(String[] args){
        int num[] = new int[4];
        int user_num;
        baseball b = new baseball();
        b.RandomSave(num);
        /*
        for(int i=0;i<3;i++){
            System.out.print(num[i] + " ");
        }
        */
        user_num = UserInput();
        System.out.println(user_num);
    }
}