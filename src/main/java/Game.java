import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private Scanner input;
    private int[] computerNumbers;
    private int[] playerNumbers;

    public Game() {
        input = new Scanner(System.in);
        setComputerNumbers(randomGenerator());
    }

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

    public void start(){
        showInputMessage();
        setPlayerNumbers(getInputsByScanner());
    }

    public int[] randomGenerator(){
        return ThreadLocalRandom.current()
                .ints(1,10)
                .distinct()
                .limit(3)
                .toArray();
    }

    public void showInputMessage(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public int[] getInputsByScanner(){
        return new int[]{input.nextInt(), input.nextInt(), input.nextInt()};
    }


}
