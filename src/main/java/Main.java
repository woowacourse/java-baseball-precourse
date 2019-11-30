/*

 */

import java.util.Scanner;
import java.util.Random;
import java.io.IOException;

/**

 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    protected static boolean[] usedNumber;
    protected static int strike;
    protected static int ball;


    public static void main(String[] args) throws IOException{
        playBaseball();
    }


    /**
     * 게임 실행 메소드
     */
    public static void playBaseball(){
        strike = 0;
        ball = 0;
        usedNumber = new boolean[10];
        int rand = createRandomNum();
        int input = 0;
        int game_end = 0;
        while(strike != 3){
            input = inputNumber();
            strike_ball_Checker(rand, input);
            print();
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                            +"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        game_end = sc.nextInt();
        if(game_end == 2){
            System.out.println("시스템 종료");
            System.exit(0);
        }

        playBaseball();
    }

    /**
     *3자리 난수를 생성하는 기능
     */
    private static int createRandomNum(){
        Random random = new Random();
        int randNumber = 0;                     //생성할 숫자
        int it = 0;                             //반복횟수

        while(it<3){
            int x = random.nextInt(9)+1;
            if(usedNumber[x]) {
                continue;
            }
            usedNumber[x] = true;
            randNumber += x*Math.pow(10,it);
            it++;
        }
        return randNumber;
    }

    /**
     * 숫자를 입력받는 기능
     */
    private static int inputNumber(){
        int input = 0;

        while(true){
            System.out.println("숫자를 입력하세요 : ");
            input = sc.nextInt();
            if((input >= 100) && (input <= 999)) {
                return input;
            }else{
                System.out.println("3자리 숫자를 입력해주세요.");
            }
        }
    }

    /**
     * 스트라이크와 볼의 갯수를 반환하는 기능
     */
    private static void strike_ball_Checker(int rand,int input){
        int randomNum;  //정답 숫자의 자릿수별로 숫자를 확인할 변수
        int inputNum;   //입력 숫자의 자릿수별로 숫자를 확인할 변수
        strike = 0;
        ball = 0;

        for(int i = 0; i<3; i++){
            randomNum = rand % 10;
            inputNum = input % 10;
            rand /= 10;
            input /= 10;

            if(randomNum == inputNum){
                strike++;
                continue;
            }

            if(ballChecker(usedNumber, inputNum)){
                ball++;
            }
        }
    }

    /**
     * 볼인지 아닌지 판단하는 기능
     */
    private static boolean ballChecker(boolean[] usedNumber, int input){
        boolean ball;

        ball = usedNumber[input];
        return ball;
    }

    private static void print(){
        if(strike == 0){
            if (ball == 0) {
                System.out.println("낫싱");
            }else{
                System.out.println(ball + " 볼");
            }
        }else if(ball == 0){
                System.out.println(strike + " 스트라이크");
        }else{
            System.out.println(strike + " 스트라이크 " + ball + " 볼");
        }
    }
}
