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

    public static void DivideByDigit(int n, int arr[]){
        for(int i=0;i<3;i++){
            arr[2-i]=n%10;
            n=n/10;
        }
    }

    public static void main(String[] args){
        int num[] = new int[4];
        int user_arr[] = new int[4];
        int user_num;
        baseball b = new baseball();
        b.RandomSave(num);

        user_num = UserInput();
        DivideByDigit(user_num, user_arr);
    }
}