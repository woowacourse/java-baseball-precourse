import java.util.Random;
import java.util.Scanner;
public class baseball {
    public static void RandomSave(int[] com_num) {
        Random random = new Random();
        boolean check_num[] = new boolean[10];
        for(int i=0;i<10;i++){
            check_num[i] = false;
        }
        int i=0;
        while (i<3) {
            int k = random.nextInt(9) + 1;
            if(check_num[k]){
               continue;
            }
            com_num[i] = k;
            check_num[k]=true;
            i++;
        }
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
        /*for(int i=0;i<3;i++)System.out.print(num[i]+" ");*/
    }
}