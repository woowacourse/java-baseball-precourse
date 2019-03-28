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

    public static int CompareNumber(int num, int idx, int usr[]){
        for(int i=0;i<3;i++){
            if(num==usr[i] && idx == i) {
                return 2;
            }
            else if (num==usr[i]){
                return 1;
            }
        }
        return 0;
    }

    public static boolean IsRightNumber(int com[], int usr[]){
        int strike = 0;
        int ball = 0;
        for(int i=0;i<3;i++){
            int op = CompareNumber(com[i], i, usr);
            switch(op){
                case 0:
                    break;
                case 1:
                    ball++;
                    break;
                case 2:
                    strike++;
                    break;
            }
        }
        System.out.println(strike + " 스트라이크 " + ball + "볼");
        if(strike ==3) {
            return true;
        }
        else {return false;}
    }

    public static int ContinueGame(){
        int com_arr[] = new int[4];
        int user_arr[] = new int[4];
        int user_num;

        RandomSave(com_arr);
        Scanner sc = new Scanner(System.in);
        do {
            user_num = UserInput();
            DivideByDigit(user_num, user_arr);

        } while (!IsRightNumber(com_arr, user_arr));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int game = sc.nextInt();

        return game;
    }

    public static void main(String[] args){
        int game = 1;
        while(game != 2) {
            game = ContinueGame();
        }
    }
}