import java.util.Arrays;
import java.util.Scanner;

public class Baseball {
    private static int strike;
    private static int ball;
    private static final int ARR_MAX_NUM = 3;

    public static void main(String args[]) {
        boolean quitCode = true; //종료할지 게임을 다시 시작할지 boolean

        /*
        게임 종료 선택 시 quitCode = false가 되어 게임이 종료되고 아니라면 playGame() 호출하여 다시 시작
         */
        while( quitCode ) {
            playGame();
            quitCode = quit();
        }
        System.out.println("게임을 종료합니다.");
    }

    private static void playGame() {
        int[] comNum = new int[ARR_MAX_NUM];
        int[] userNum = new int[ARR_MAX_NUM];
        boolean checkInputErr;

        comNum = makeRandomNumber(comNum);
        while ( true ) {
            checkInputErr = inputUserNumber(userNum);
            if( !checkInputErr ) {
                return;
            }

            compare(comNum, userNum); //컴퓨터와 사용자의 숫자 배열 비교
            hint(strike, ball);

            if( strike == ARR_MAX_NUM ) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다.! 게임 종료");
                break;
            }
        }
    }

    /** 컴퓨터의 수 3개 랜덤으로 생성 */
    private static int[] makeRandomNumber(int[] comNum) {
        boolean check;

        for(int i = 0; i < ARR_MAX_NUM; i++) {
            comNum[i] = (int) (Math.random() * 9) + 1;
            check = checkOverlap(comNum[i], comNum, i);
            if( !check ) {
                i -= 1;
            }
        }
        return comNum;
    }

    /*
     * 유저로부터 3개의 수 입력
     * 3개보다 적거나 많이 입력되면 게임 종료
    */
    private static boolean inputUserNumber(int[] userNum) {
        int num;
        Scanner sc = new Scanner(System.in);
        int i = ARR_MAX_NUM;
        System.out.print("숫자를 입력해 주세요 : ");
        num = sc.nextInt();
        while(num!=0) {
            userNum[--i] = num % 10;
            num = num / 10;
            if(i == 0 && num != 0) {
                System.out.println("3개 이상의 수가 입력되었습니다.");
                return false;
            }
        }
        if(i > 0) {
            System.out.println("수가 3개보다 적게 입력되었습니다.");
            return false;
        }
        return true;
    }

    /** 난수의 중복 여부를 검사하는 메서드 */
    private static boolean checkOverlap(int num, int[] comNum, int i) {
        for(int j=0; j<i; j++) {
            if(comNum[j] == num) {
                return false;
            }
        }
        return true;
    }

    /** 숫자 비교 후 사용자에게 힌트를 주는 코드 */
    private static void compare(int[] comNum, int[] userNum) {
        strike = 0;
        ball = 0;
        int[] result = new int[2];

        for(int i = 0; i< ARR_MAX_NUM; i++) {
            for(int j = 0; j< ARR_MAX_NUM; j++) {
                compare2(comNum[i], userNum[j], i, j);
            }
        }
    }

    /** 컴퓨터의 숫자와 유저의 숫자가 같은지 비교해주는 메서드 (ball과 strike의 개수 세줌) */
    private static void compare2(int com, int user, int i, int j) {
        if(com == user) {
            if(i == j) {
                strike++;
            }else {
                ball++;
            }
        }
    }

    /** 유저에게 hint를 출력 */
    private static void hint(int strike, int ball) {
        if(strike != 0 && ball != 0) {
            System.out.println(strike+" 스트라이크 "+ball+" 볼");
        } else if(strike == 0 && ball != 0) {
            System.out.println(ball+" 볼");
        } else if(strike != 0 && ball == 0) {
            System.out.println(strike+ " 스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }

    /** 게임 종료 여부를 물어보는 메서드 */
    private static boolean quit() {
        int userCode;
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        userCode = sc.nextInt();
        if(userCode == 1) {
            return true;
        } else {
            return false;
        }
    }
}