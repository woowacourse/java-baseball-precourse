package baseball;

import java.util.ArrayList;
import java.util.Scanner;

//게임이 돌아가는 것을 관리하는 class
public class GameCycle{
    static private ArrayList<Integer> UserValue = new ArrayList<>(Application.LENGTH);
    static private ArrayList<Integer> CompValue = new ArrayList<>(Application.LENGTH);
    final Scanner scanner = new Scanner(System.in);

    GameCycle(){
        MakeNumber CompM = new MakeNumber();
        this.CompValue = CompM.GetTarget();
    }

    private boolean GetHint(){
        int ball = 0;
        int strike = 0;
        for(Integer element : UserValue){
            if(!CompValue.contains(element)){
                continue;
            }
            if(CompValue.indexOf(element) != UserValue.indexOf(element)){
                ball++;
            }
            if(CompValue.indexOf(element) == UserValue.indexOf(element)){
                strike++;
            }
        }
        if(ball == 0 && strike == 0){
            System.out.println("낫싱");
            return false;
        }
        if(strike == 0){
            System.out.println(ball + "볼");
            return false;
        }
        if(ball == 0){
            if(strike == 3){
                System.out.println(strike + "스트라이크");
                return true;
            }
            System.out.println(strike + "스트라이크");
            return false;
        }
        System.out.println(ball + "볼 "+strike + "스트라이크");
        return false;
    }

    //게임을 시작하는 함수.
    public void GameStart(int answer){
        //사용자의 입력값 저장.
        //그리고 예외를 처리한다면 여기서 하는 게 나은 거 같음.
        MakeNumber UserM = new MakeNumber(answer);
        this.UserValue = UserM.GetTarget();

        /*
        이제는 while문을 통하여, 사용자의 입력을 계속해서 받아야 함.
        그러면서, 볼, 스트라이크, 낫싱 아니면 합격을 판단하는 함수가 필요함.


         */
        //test
        for(Integer a : CompValue){
            System.out.print(a);
        }
        System.out.println();

        while(!GetHint()){
            System.out.println("값을 입력해주세요.");
            MakeNumber User = new MakeNumber(scanner.nextInt());
            this.UserValue = User.GetTarget();
        }

    }
}
