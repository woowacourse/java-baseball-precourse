import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

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
            do {
                showInputMessage();
                setPlayerNumbers(getInputsByScanner());
            } while (isWrongArgs(playerNumbers) || isOverlap(playerNumbers)
                    || isOutOfScope(playerNumbers));
        } while (!showResult() || inputRestart());
    }

    public int[] randomGenerator() {
        return ThreadLocalRandom.current().ints(1,10)
                .distinct()
                .limit(3)
                .toArray();
    }

    public void showInputMessage() {
        System.out.print("Input Number : ");
    }

    public int[] getInputsByScanner() {
        try {
            return Stream.of(input.next().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e){
            return new int[]{-1};
        }
    }

    public boolean isOverlap(int[] numbers) {
        return Arrays.stream(numbers).distinct().count() < 3;
    }

    public boolean isOutOfScope(int[] numbers) {
        return Arrays.stream(numbers).anyMatch(x -> (x < 1 || x > 9));
    }

    public boolean isWrongArgs(int[] numbers){
        return numbers.length != 3;
    }

    public int checkStrike() {
        int count = 0;
        for (int i = 0; i < computerNumbers.length; i++){
            if (computerNumbers[i] == playerNumbers[i]){
                playerNumbers[i] = 0;
                count++;
            }
        }
        return count;
    }

    public int checkBall() {
        int count = 0;
        for (int i = 0; i < computerNumbers.length; i++){
            final int index = i;
            count += Arrays.stream(computerNumbers).filter(x -> x == playerNumbers[index]).count();
        }
        return count;
    }

    public boolean showResult() {
        int strike = checkStrike();
        int ball = checkBall();

        if (ball + strike == 0){
            System.out.println("Nothing!");
        } else if (strike == 0) {
            System.out.println(ball + " ball");
        } else if (ball == 0){
            System.out.println(strike + " strike");
        } else {
            System.out.println(strike + " strike " + ball + " ball");
        }
        return isWin(strike);
    }

    public void showRestart(){
        System.out.println("Restart : 1, Quit : 2");
    }

    public boolean inputRestart(){
        showRestart();
        setComputerNumbers(randomGenerator());
        return input.nextInt() == 1;
    }

    public boolean isWin(int strike){
        if(strike == 3){
            System.out.println("you win!! GameOver");
            return true;
        } else {
            return false;
        }
    }
}
