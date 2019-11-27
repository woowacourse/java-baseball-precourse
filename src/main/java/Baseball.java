import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Baseball {
    static int strike;
    static int ball;
    public static void main(String args[]) {
        int[] comNum = new int[3];
        boolean check;
        int[] userNum = new int[3];
        int num;
        boolean strikeNumCheck;
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
            //숫자 비교 후 힌트 && strike 3 나오면 종료
            strikeNumCheck = compare(comNum, userNum);

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

    //숫자 비교 후 힌트 주는 메소드
    public static boolean compare(int[] comNum, int[] userNum) {
        strike = 0;
        ball = 0;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                compare2(comNum[i], userNum[j], i, j);
            }
        }

        if(strike != 0 && ball != 0) {
            System.out.println(strike+" 스트라이크 "+ball+" 볼");
        } else if(strike == 0 && ball != 0) {
            System.out.println(ball+" 볼");
        } else if(strike != 0 && ball == 0) {
            System.out.println(strike+ " 스트라이크");
        } else {
            System.out.println("낫싱");
        }
        return ((strike == 3) ? true : false);
    }

    public static void compare2(int com, int user, int i, int j) {
        if(com == user) {
            if(i == j) {
                strike++;
            }else {
                ball++;
            }
        }
    }
}