import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
/**
 * Baseball은 숫자야구 수행을 위한 클래스이다.
 * 객체를 생성해 playMethod와 exitMethod를 통해 컨트롤할 수 있다.
 * 작은 기능을 담당하는 세부함수들은 private로 정리해두고 내부에서만 호출하게 유도한다.
 *
 * @version 1.00 2019년 12월 2일
 * @author 이건희
 */
public class Baseball {
    /**
     * 본 숫자게임에서, 데이터(3자리 숫자)는 3칸의 int형 배열로 하였다.
     * 비교, 저장의 용이함 뿐 아니라 가독성에서도 그것이 낫다고 판단하였기 때문이다.
     * 이외 로직은 각 함수 주석을 참고 바람.
     */

    /** answerData는 게임을 시작할 때 생성하여 보관하는 정답 데이터이다. */
    private int[] answerData;

    /** userData는 사용자의 입력을 통해 생성된 데이터이다. */
    private int[] userData;

    /** 입력을 위한 Scanner 변수이다. */
    Scanner sc;

    /**
     * 생성자 함수.
     * 객체를 생성하면, 내부 변수들의 기본 클래스를 생성해준다.
     */
    public Baseball(){
        answerData = new int[3]; //answerData는 정답값, playMethod 호출시 값 생성/부여
        userData = new int[3]; //userData는 사용자 입력값, playMethod에서 getData 호출로 값 입력/부여
        sc = new Scanner(System.in); //input scanner class 생성
    }

    /**
     * makeAnswerData 메서드는 데이터를 생성해주고, 그 값을 answerData에 넣어준다.
     */
    private void makeAnswerData(){
        Random random = new Random();
        answerData[0] = (random.nextInt(9) + 1);
        do {
            answerData[1] = (random.nextInt(9) + 1);
        }while(answerData[0] == answerData[1]);
        do{
            answerData[2] = (random.nextInt(9) + 1);
        }while( (answerData[0] == answerData[2]) || (answerData[1] == answerData[2]) );
    }

    /**
     * getUserData는 사용자에게 입력을 받고, 그 값을 int[3]으로 쪼개 저장한다.
     * 입력값에 대해 InputMismatchException을 검사한다.
     * 이외에, 입력값이 범위를 벗어나는 경우를 처리해준다.
     * */
    private void getUserData(){
        int input;
        try {
            input = sc.nextInt();
        }catch(InputMismatchException e){
            sc = new Scanner(System.in);
            System.out.println("잘못된 값을 입력하셨습니다.");
            //input exception. 0으로 값을 덮어씌워 아예 볼/스트라이크를 배제한다.
            userData[0] = 0;
            userData[1] = 0;
            userData[2] = 0;
            return;
        }
        if(input > 999 || input < 100){
            //input exception. 만약 3자리수가 아니라면?
            userData[0] = 0;
            userData[1] = 0;
            userData[2] = 0;
            return;
        }
        userData[0] = input / 100;
        input %= 100;
        userData[1] = input / 10;
        userData[2] = input % 10;
    }

    /**
     * getBall 메서드는 정수 번지값을 받아, 해당 위치의 숫자가 볼인지 여부를 판단해 값을 리턴해준다.
     *
     * @param pos 번지값을 전달하는 int형 변수
     * @return int형 정수값( 1 / 0 )
     */
    private int getBall(int pos) {
        /*
        * 입력된 위치의 숫자가 볼인지 아닌지 판정하여 1,0을 리턴
        * */
        for(int i=0;i<3;i++) {
            if (i != pos && answerData[i] == userData[pos]){
                return 1;
            }
        }
        return 0;
    }

    /**
     * getStrike 메서드는 정수 번지값을 받아, 해당 위치의 숫자가 스트라이크인지 여부를 판단해 값을 리턴해준다.
     *
     * @param pos 번지값을 전달하는 int형 변수
     * @return int형 정수값( 1 / 0 )
     */
    private int getStrike(int pos) {
        /*
         * 입력된 위치의 숫자가 스트라이크인지 아닌지 판정하여 1,0을 리턴
         * */
        if(answerData[pos] == userData[pos]){
            return 1;
        }
        return 0;
    }

    /**
     * printState 메서드는 스트라이크/볼 상황을 받아, 그에 맞는 문자열을 출력해준다.
     *
     * @param strike 스트라이크가 몇 번 발생하였는지 전달하는 int형 변수
     * @param ball 볼이 몇 번 발생하였는지 전달하는 int형 변수
     */
    private void printState(int strike, int ball){
        if(strike == 0 && ball == 0){
            /**
             * 낫싱일 경우 뒤의 두 연산은 치를 필요가 없고, 본 조건문의 조건이 제일 빡빡해서
             * 여기서 검사를 해주고, 낫싱일 경우 바로 종료되도록 설계하였음.
             * */
            System.out.println("낫싱");
            return;
        }
        if(strike != 0){
            System.out.println(strike+" 스트라이크 ");
        }
        if(ball != 0){
            System.out.println(ball+" 볼");
        }
    }

    /**
     * getResult는 스트라이크와 볼이 몇 번 발생했는지 확인하여,
     * 게임이 종료되는지를 출력해주는(결과를 전달하는) 함수이다.
     *
     * @return 스트라이크가 3회 발생했다면 true, 아닐 경우 false
     */
    private boolean getResult(){
        int strike = 0;
        int ball = 0;

        for(int i=0;i<3;i++) {
            //각 숫자를 순회하면서 strike / ball 여부 누적
            strike += getStrike(i);
            ball += getBall(i);
        }
        //System.out.println("입력 데이터 : "+userData[0]+" "+userData[1]+" "+userData[2]+" ");//log
        printState(strike, ball);
        return (strike == 3);
    }

    /**
     * playMethod는 이 객체를 사용하는 상위 객체에서 직접 호출된다.
     * 함수 실행시 정답 데이터와 유저 데이터를 생성해주고,
     * getResult 메서드의 return값에 따라 종료(즉, 3 스트라이크로 정답을 맞추는 때)까지 루프를 실행한다.
     */
    public void playMethod(){
        makeAnswerData();
        //System.out.println("만든 데이터 : "+answerData[0]+" "+answerData[1]+" "+answerData[2]+" ");//log
        do{
            System.out.print("숫자를 입력해주세요 : ");
            getUserData();
        }while(!getResult());
    }

    /**
     * exitMethod는 이 객체를 사용하는 상위 객체에서 직접 호출된다.
     * (게임이 종료된 후 게임을 다시 진행하는 옵션을 넣는 경우에 한한다.)
     * exitMethod는 입력을 받고,
     * 그 값이 1이면 게임을 다시 진행해도 괜찮다고 전달하고,
     * 그 외의 값(0, 오류값 등)이 들어올 경우엔 게임을 종료하라고 전달한다.
     * 입력 input에 대해 정수 이외값을 대비하여 InputMismatchException이 적용되었고,
     * 이외에도 1,2 이외의 값이 들어올 경우 switch문을 통해 통과시킨다.
     *
     * @return 게임이 종료될 경우 true, 계속 진행될 경우 false를 리턴해준다.
     */
    public boolean exitMethod() {
        int input;
        try {
            input = sc.nextInt();
        }catch(InputMismatchException e){
            //exception 발생할 경우, 에러로 간주하고 프로그램 종료를 위해 true 리턴.
            System.out.println("잘못된 입력값이 들어왔습니다. 프로그램을 종료합니다.");
            return true;
        }
        switch(input){
        case 1 :
            //게임을 다시 한 번 플레이한다. 아직 종료하지 않으므로 false
            return false;
        case 2 :
            //게임을 여기서 종료한다. 종료하므로 true
            return true;
        default:
            //입력이 범위를 벗어난 경우. 에러이므로 true로 종료시킨다.
            System.out.println("잘못된 입력값이 들어왔습니다. 프로그램을 종료합니다.");
            return true;
        }
    }
}
