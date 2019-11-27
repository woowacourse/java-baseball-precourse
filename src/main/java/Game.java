import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private Scanner input;
    private int[] computerNumbers;
    private int[] playerNumbers;

    public int[] getComputerNumbers() {
        return computerNumbers;
    }

    public void setComputerNumbers(int[] computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public int[] getPlayerNumbers() {
        return playerNumbers;
    }

    public void setPlayerNumbers(int[] playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public Game() {
        Scanner input = new Scanner(System.in);
        setComputerNumbers(randomGenerator());
    }

    public void start(){
        showInputMessage();
    }

    public int[] randomGenerator(){
        return ThreadLocalRandom.current()
                .ints(1,10)
                .limit(3)
                .toArray();
    }

    public void showInputMessage(){
        System.out.print("숫자를 입력해주세요 : ");
    }



}
