package baseball;

import java.util.ArrayList;
import java.util.Scanner;

//게임이 돌아가는 것을 관리하는 class
public class GameCycle{
    static private ArrayList<Integer> UserValue = new ArrayList<>(Application.LENGTH);
    static private ArrayList<Integer> CompValue = new ArrayList<>(Application.LENGTH);
    final Scanner scanner = new Scanner(System.in);

    GameCycle(){
        MakingNumber CompM = new MakingNumber();
        this.CompValue = CompM.GetTarget();
    }

    private int CheckBall(Integer element){
        if(!CompValue.contains(element)) return 0;
        if(CompValue.indexOf(element) != UserValue.indexOf(element)) return 1;
        return 0;
    }

    private int CheckStrike(Integer element){
        if(!CompValue.contains(element)) return 0;
        if(CompValue.indexOf(element) == UserValue.indexOf(element)) return 1;
        return 0;
    }

    private void PrintBall(int ball){
        if(ball > 0)
            System.out.print(ball + "볼 ");
    }

    private void PrintStrike(int strike){
        if(strike == 0)
            System.out.println();
        if(strike > 0)
            System.out.println(strike + "스트라이크");
        if(strike == 3)
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean CheckHint(int ball, int strike){
        if(ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return false;
        }
        PrintBall(ball);
        PrintStrike(strike);

        if(strike == 3)
            return true;
        return false;
    }

    private boolean GetHint(boolean check){
        int ball = 0;
        int strike = 0;
        //오류가 떴을 때, 이 함수가 돌필요가 없음
        if(check == false)
            return false;

        for(Integer element : UserValue){
            ball+=CheckBall(element);
            strike+=CheckStrike(element);
        }

        return CheckHint(ball, strike);
    }

    private void Input()throws IllegalArgumentException{
        System.out.println("숫자를 입력해주세요.");
        MakingNumber User = new MakingNumber(scanner.nextInt());
        this.UserValue = User.GetTarget();
    }

    //게임을 시작하는 함수.
    public void GameStart(){
        boolean check = true;
        //test
        for(Integer a : CompValue){
            System.out.print(a);
        }
        System.out.println();

        do {
            try {
                Input();
                check = true;
            }catch (IllegalArgumentException i){
                System.out.println(i.getMessage());
                check = false;
            }
        }
        while(!GetHint(check));
    }
}
