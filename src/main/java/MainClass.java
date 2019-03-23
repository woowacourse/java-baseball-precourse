import java.util.Scanner;

public class MainClass {

    public void runGame(){
        RandomNumber rn = new RandomNumber();
        Baseball b = new Baseball();
        rn.setRandomNum();
        b.setInputNum();
        b.setCheckStrike(rn);
        b.setCheckBall(rn);

    }
    public static void main(String[] args){
        MainClass mc = new MainClass();
        mc.runGame();
    }
}
