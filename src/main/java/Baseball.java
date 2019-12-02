import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
public class Baseball {
    /*
     * Baseball은 숫자야구 수행을 위한 클래스이다.
     * 큰 기능을 담당하는 함수들을 public 메소드로 분류하여 호출할 수 있게 하고,
     * 작은 기능을 담당하는 세부함수들은 private로 정리해두고 내부에서만 호출하게 유도한다.
     * 메서드 기능을 더 쪼갤 필요가 있다.
     */
    private int[] answerData;
    private int[] userData;
    Scanner sc;

    private int[] makeData(){
        int[] randomNumber = new int[3];
        Random random = new Random();
        randomNumber[0] = (random.nextInt(9) + 1);
        do {
            randomNumber[1] = (random.nextInt(9) + 1);
        }while(randomNumber[0] == randomNumber[1]);
        do{
            randomNumber[2] = (random.nextInt(9) + 1);
        }while( (randomNumber[0] == randomNumber[2]) || (randomNumber[1] == randomNumber[2]) );
        //서로 다른 값이어야함!!
        return randomNumber;
    }
    /*
     * 
     *
     * */
    private void getData(){
        int input;
        try {
            input = sc.nextInt();
            //예외처리부
            //해야할일 : 숫자가 엉뚱한 값 들어오는 경우 예외처리문 짜리
            userData[0] = input / 100;
            input %= 100;
            userData[1] = input / 10;
            userData[2] = input % 10;
        }catch(InputMismatchException e){
            //input exception. 0으로 값을 덮어씌워 아예 값을 배제한다.
            sc = new Scanner(System.in);
            userData[0] = 0;
            userData[1] = 0;
            userData[2] = 0;
            System.out.println("잘못된 값을 입력하셨습니다.");
        }
    }

    public Baseball(){
        /*
         * 생성자 메서드.
         * 시작할 때 초기화해야 할 값들을 정리해준다.
         * */
        answerData = new int[3]; //answerData는 정답값, playMethod 호출시 값 생성/부여
        userData = new int[3]; //userData는 사용자 입력값, playMethod에서 getData 호출로 값 입력/부여
        sc = new Scanner(System.in); //input scanner class 생성
    }
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
    private int getStrike(int pos) {
        /*
         * 입력된 위치의 숫자가 스트라이크인지 아닌지 판정하여 1,0을 리턴
         * */
        if(answerData[pos] == userData[pos]){
            return 1;
        }
        return 0;
    }
    private void printState(int strike, int ball){
        if(strike != 0){
            System.out.println(strike+" 스트라이크 ");
        }
        if(ball != 0){
            System.out.println(ball+" 볼");
        }
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        }
    }
    private boolean getResult(){
        int strike = 0;
        int ball = 0;

        for(int i=0;i<3;i++) {
            strike += getStrike(i);
            ball += getBall(i);
        }
        System.out.println("입력 데이터 : "+userData[0]+" "+userData[1]+" "+userData[2]+" ");//log
        printState(strike, ball);
        return (strike == 3); //game이 끝날 수 있는지 여부만 리턴해줌.
    }
    public void playMethod(){
        answerData = makeData();
        System.out.println("만든 데이터 : "+answerData[0]+" "+answerData[1]+" "+answerData[2]+" ");//log
        do{
            System.out.println("숫자를 입력해주세요 : ");
            getData();
        }while(!getResult());
    }
    public boolean exitMethod() {
        /*
        * play 메서드가 종료된 후 실행되어 추가입력을 받는 메서드.
        * 입력을 바탕으로, "끝낼 수 있는지" 여부를 판단하여 boolean으로 return.
        * */
        int input;
        try {
            input = sc.nextInt();
        }catch(InputMismatchException e){
            //exception 발생할 경우, 아예 프로그램이 종료됨. 별도의 스캐너 처리 안해줬음.
            System.out.println("잘못된 입력값이 들어왔습니다. 프로그램을 종료합니다.");
            return true;
        }
        switch(input){
        case 1 :
            return false;
        case 2 :
            return true;
        default:
            System.out.println("잘못된 입력값이 들어왔습니다. 프로그램을 종료합니다.");
            return true;
        }
    }
}
