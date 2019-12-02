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
}
