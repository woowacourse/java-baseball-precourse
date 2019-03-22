import java.util.Scanner;

public class MainClass {

    public void runGame(){
        RandomNumber rn = new RandomNumber();
        rn.setRandomNum();
    }
    
    public static void main(String[] args){
        MainClass mc = new MainClass();
        mc.runGame();
    }
}
