package baseball;

import java.util.ArrayList;
import java.util.Scanner;

//게임이 돌아가는 것을 관리하는 class
public class GameCycle{
    static private ArrayList<Integer> userValue = new ArrayList<>(Application.LENGTH);
    static private ArrayList<Integer> comValue = new ArrayList<>(Application.LENGTH);
    final Scanner scanner = new Scanner(System.in);

    GameCycle(){
        MakingNumber CompM = new MakingNumber();
        this.comValue = CompM.getTarget();
    }

    private int checkBall(Integer element){
        if(!comValue.contains(element)) return 0;
        if(comValue.indexOf(element) != userValue.indexOf(element)) return 1;
        return 0;
    }

    private int checkStrike(Integer element){
        if(!comValue.contains(element)) return 0;
        if(comValue.indexOf(element) == userValue.indexOf(element)) return 1;
        return 0;
    }

    private void printBall(int ball){
        if(ball > 0)
            System.out.print(ball + "볼 ");
    }

    private void printStrike(int strike){
        if(strike == 0)
            System.out.println();
        if(strike > 0)
            System.out.println(strike + "스트라이크");
        if(strike == 3)
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean checkHint(int ball, int strike){
        if(ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return false;
        }
        printBall(ball);
        printStrike(strike);

        if(strike == 3)
            return true;
        return false;
    }

    private boolean getHint(boolean check){
        int ball = 0;
        int strike = 0;
        //오류가 떴을 때, 이 함수가 돌필요가 없음
        if(check == false)
            return false;

        for(Integer element : userValue){
            ball+= checkBall(element);
            strike+= checkStrike(element);
        }

        return checkHint(ball, strike);
    }

    private void input()throws IllegalArgumentException{
        System.out.println("숫자를 입력해주세요.");
        MakingNumber User = new MakingNumber(scanner.next());
        this.userValue = User.getTarget();
    }

    //게임을 시작하는 함수.
    public void gameStart(){
        boolean check = true;
        do {
            try {
                input();
                check = true;
            }catch (IllegalArgumentException i){
                System.out.println(i.getMessage());
                check = false;
            }
        }
        while(!getHint(check));
    }
}
