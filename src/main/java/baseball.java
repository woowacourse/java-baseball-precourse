import java.util.Random;
import java.util.Scanner;

public class baseball {
    static int gameCnt = 0;
    static int strCnt = 0;
    static int ballCnt = 0;
    static int ball = 0;
    static int strike = 0;
    static int hun;
    static int ten;
    static int one;

    // 3개의 랜덤숫자 설정
    public static void setNum() {

        boolean stop = false;
        Random random = new Random();
        hun = random.nextInt(10);
        ten = random.nextInt(10);
        one = random.nextInt(10);
        while (!stop) {
            stop = Numchk();
        }
    }
    //같은 숫자 재설정
    public static boolean Numchk(){
        Random random = new Random();
        if((ten==hun) || (ten==one)) {
            ten = random.nextInt(10);
            return false;
        }else if((one==hun) || (one==ten)) {
            one = random.nextInt(10);
            return false;
        }
        else {
            return true;
        }
    }
    // Input 영역
    public static boolean getNum(int num1, int num2, int num3) {
        strCnt = Strike(num1, num2, num3);
        ballCnt = Ball(num1, num2, num3);
        gameCnt++;
        System.out.println(strCnt + "Strikes " + ballCnt + "Balls");
        return checkAns();
    }


    // Ball, 즉 위치는 다르지만 같은 값을 입력하였는가
    public static int Ball(int a, int b, int c) {
        ball = 0;
        if((a == ten) || (a == one))
            ball++;
        if((b == hun) || (b == one))
            ball++;
        if((c == hun) || (c == ten))
            ball++;
        return ball;
    }
    // Strike, 즉 위치와 데이터가 모두 같은 것 확인
    public static int Strike(int a, int b, int c) {
        strike = 0;
        if((a == hun))
            strike++;
        if(b == ten)
            strike++;
        if(c == one)
            strike++;
        return strike;
    }

    // Check Answer 하는 부분
    public static boolean checkAns() {
        if(strCnt == 3){
            System.out.println("You won the game!!!");
            System.out.println("Game Over");
            return true;
        }
        return false;
    }
    // Game을 들어가는 부분
    public static void Game(){
        setNum();
        int input;
        boolean check = false;
        Scanner n = new Scanner(System.in);
        while(!check) {
            System.out.println("Insert Number");
            input = n.nextInt();
            check = getNum(input / 100, (input % 100) / 10, input % 10);
        }
        return;
    }
    //Main부분, 시작과 종료를 확인
    public static void main(String[] args){
        int input;
        int check = 1;
        Scanner n = new Scanner(System.in);

        while(check==1) {
            Game();
            System.out.println("Continue : 1 , End : 2");
            input = n.nextInt();
            check = input;
        }
    }
}
