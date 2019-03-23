import java.util.Scanner;

public class MainClass {

    public void runGame(){
        RandomNumber rn = new RandomNumber();
        Baseball b = new Baseball();
        rn.setRandomNum();
        while(true){
            b.setInputNum();
            b.setCheckStrike(rn);
            b.setCheckBall(rn);
            if(b.printResult()){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

    }
    public static void main(String[] args){
        MainClass mc = new MainClass();
        mc.runGame();
    }
}
