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

    public void start() {
        do {
            showInputMessage();
            setPlayerNumbers(getInputsByScanner());
        } while (isOverlap(getPlayerNumbers()) || isOutOfScope(getPlayerNumbers()));

    }

    public int[] randomGenerator() {
        return ThreadLocalRandom.current().ints(1,10)
                .distinct()
                .limit(3)
                .toArray();
    }

    public void showInputMessage() {
        if(playerNumbers != null){
            System.out.println("잘못된 입력입니다.");
        }
        System.out.print("숫자를 입력해주세요 : ");
    }

    public int[] getInputsByScanner() {
        return new int[]{input.nextInt(), input.nextInt(), input.nextInt()};
    }

    public boolean isOverlap(int[] numbers) {
        return Arrays.stream(numbers).distinct().count() < 3;
    }

    public boolean isOutOfScope(int[] numbers) {
        return Arrays.stream(numbers).anyMatch(x -> (x < 1 || x > 9));
    }

}
