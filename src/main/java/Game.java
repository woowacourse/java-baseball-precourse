import java.util.Scanner;

public class Game {
    private Scanner input;
    private int[] computerNumbers;
    private int[] playerNumbers;

    public Game() {
        Scanner input = new Scanner(System.in);
        RandomGenerator();
    }

    public void start(){
        showInputMessage();
    }

    public void RandomGenerator(){

    }

    public void showInputMessage(){
        System.out.print("숫자를 입력해주세요 : ");
    }



}
