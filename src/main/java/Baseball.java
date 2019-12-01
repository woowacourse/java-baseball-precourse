import java.util.Scanner;
import java.util.Random;
public class Baseball {
    /*
     * Baseball은 숫자야구 수행을 위한 클래스이다.
     *
     */
    public int[] makeData(){
        int[] randomNumber = new int[3];
        Random random = new Random();
        randomNumber[0] = (random.nextInt(9) + 1);
        randomNumber[1] = (random.nextInt(9) + 1);
        randomNumber[2] = (random.nextInt(9) + 1);
        return randomNumber;
    }
    public int findBall(int[] answerData, int userNum, int pos) {
        for(int i=0;i<3;i++) {
            if (i != pos && answerData[i] == userNum){
                return 1;
            }
        }
        return 0;
    }
    public boolean checkMethod(int[] answerData, int[] userData){
        int strike = 0;
        int ball = 0;
        //strike = getStrike(answerData, userData);
        //ball = getBall(answerData, userData);
        //test를 위해 노가다 소스로 짜두고 나중에 수정 예정
        for(int i=0;i<3;i++) {
            if (answerData[i] == userData[i]) strike++;
            ball += findBall(answerData, userData[i], i);
        }
        System.out.println("입력 데이터 : "+userData[0]+" "+userData[1]+" "+userData[2]+" \n");
        if(strike != 0){
            System.out.println(strike+" 스트라이크 ");
        }
        if(ball != 0){
            System.out.println(ball+" 볼");
        }
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        }
        System.out.println("\n");
        return (strike == 3);
    }
    public void playMethod(){
        int[] answerData = makeData();
        int[] userData;
        boolean isEnd=false;
            System.out.println("만든 데이터 : "+answerData[0]+" "+answerData[1]+" "+answerData[2]+" \n");
            while(isEnd == false){
            System.out.println("숫자를 입력해주세요 : ");
            userData =  getData();
            isEnd = checkMethod(answerData, userData);
        }
    }
    public int[] getData(){
        int input;
        int[] data = new int[3];
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();
        //예외처리부
        data[0] = input/100;
        input %= 100;
        data[1] = input/10;
        data[2] = input%10;
        return data;
    }
    public boolean exitMethod() {
        int input;
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();
        if (input == 1) {//이 부분의 로직이 마음에 들지는 않지만...더 직관적인 리턴법은?
            return false;
        } else if (input == 2) {
            return true;
        } else {
            /*
             * 1,2 외의 입력이 들어온 경우 : true 리턴해주고 메세지 출력.
             * 리턴값을 boolean으로 하지 않고 int로 해서 state를 넘길 수 있다면 좋겠지만
             * 일단 함수의 목적을 [나가느냐 마느냐에 대한 리턴]으로 두고,
             * 오류시 종료하는 것이 합리적이라 보고 true 리턴을 하였다.
             */
            System.out.println("잘못된 입력값이 들어왔습니다. 프로그램을 종료합니다.\n");
            return true;
        }
    }
}
