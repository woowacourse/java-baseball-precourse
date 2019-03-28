/*
* 클래스 이름 : baseball.java
*
* 버전 정보 : 1.0.1
*
* 날짜 : 2019.03.28
*
* 작성자 : 483759*
* */

import java.util.Random;
import java.util.Scanner;

/*
* baseball 클래스는 컴퓨터가 랜덤으로 설정한 1부터 9까지의 서로 다른 수로 이루어진
* 3자리의 숫자를 맞추는 숫자야구 게임을 구현한 클래스입니다
*
* 숫자와 자리가 일치하면 1스트라이크, 숫자는 일치하고 자리가 일치하지 않으면 1볼
* 아무것도 일치하지 않으면 낫싱입니다
*
* 사용자는 컴퓨터가 임의로 정한 숫자를 맞추고, 3개의 숫자를 모두 맞히면 게임이 종료됩니다.
* 게임이 종료된 후, 1을 입력하면 재시작, 2를 입력하면 게임이 완전히 종료됩니다.
*  */
public class baseball {
    public static void RandomSave(int[] com_num) {
        /*
        * 랜덤한 숫자를 컴퓨터에 저장하는 메소드
        * */
        Random random = new Random();   //임의의 수를 정하기 위한 변수
        boolean check_num[] = new boolean[10];  //숫자의 중복을 체크하는 배열
        for(int i=0;i<10;i++){
            check_num[i] = false;   /*배열 초기화*/
        }
        int i=0;
        while (i<3) {
            /*3개의 숫자를 다 고를때까지*/
            int k = random.nextInt(9) + 1;
            if(check_num[k]){
                /*이미 정한 숫자일 경우*/
               continue;
            }
            /*배열에 숫자를 저장하고 숫자의 출현을 체크한다*/
            com_num[i] = k;
            check_num[k]=true;
            i++;
        }
    }

    public static int UserInput(){
        /*
        * 사용자에게 숫자를 입력하여 반환하는 메소드
        * */
        int us_input;
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        us_input = sc.nextInt();
        return us_input;
    }

    public static void DivideByDigit(int n, int arr[]){
        /*
        * 입력받은 숫자를 한 자리씩 나누어 배열에 저장하는 메소드
        * */
        for(int i=0;i<3;i++){
            arr[2-i]=n%10;
            /*숫자의 마지막 자리를 배열에 저장*/
            n=n/10;
        }
    }

    public static int CompareNumber(int num, int idx, int usr[]){
        /*
        * 숫자와 인덱스를 인자로 받아 스트라이크 또는 볼에 해당하는지
        * 검사하여 반환하는 메소드
        * */
        for(int i=0;i<3;i++){
            if(num==usr[i] && idx == i) {
                /*숫자와 자리가 모두 일치한다면 스트라이크*/
                return 2;
            }
            else if (num==usr[i]){
                /*숫자만 일치한다면 볼*/
                return 1;
            }
        }
        /*모두 일치하지 않는다면 낫싱*/
        return 0;
    }

    public static boolean IsRightNumber(int com[], int usr[]){
        /*
        * 컴퓨터와 사용자의 숫자 배열을 비교하는 메소드
        * */
        int strike = 0;
        int ball = 0;
        for(int i=0;i<3;i++) {
            int op = CompareNumber(com[i], i, usr);
            /*한 자리씩 나누어 스트라이크/볼 수를 계산*/
            switch (op) {
                case 0:
                    break;
                case 1: //볼 수 증가
                    ball++;
                    break;
                case 2: //스트라이크 수 증가
                    strike++;
                    break;
            }
        }
        if(ball==0&&strike==0){
            System.out.println("낫싱");
        }
        else {
            System.out.println(strike + " 스트라이크 " + ball + "볼");
        }
        if(strike ==3) {
            /*3스트라이크일 경우 true 반환*/
            return true;
        }
        else {return false;}
    }

    public static int ContinueGame(){
        /*
        * 게임을 진행하는 메소드
        * */
        int com_arr[] = new int[4]; //컴퓨터의 숫자 저장 배열
        int user_arr[] = new int[4];    //사용자의 숫자 저장 배열
        int user_num;   //사용자의 입력 저장

        RandomSave(com_arr);
        Scanner sc = new Scanner(System.in);
        do {
            /*스트라이크 수가 3이 아니면 반복*/
            user_num = UserInput();
            DivideByDigit(user_num, user_arr);
        } while (!IsRightNumber(com_arr, user_arr));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int game = sc.nextInt();

        return game;
    }

    public static void main(String[] args){
        int game = 1;   //게임 지속을 결정하는 변수
        while(game != 2) {
            game = ContinueGame();
        }
    }
}