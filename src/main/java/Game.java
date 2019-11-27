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
        } while (isOverlap(playerNumbers) || isOutOfScope(playerNumbers));

        showResult();
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

    public int checkStrike(){
        int count = 0;
        for(int i = 0; i < computerNumbers.length; i++){
            if(computerNumbers[i] == playerNumbers[i]){
                playerNumbers[i] = 0;
                count++;
            }
        }
        return count;
    }

    public int checkBall(){
        int count = 0;
        for(int i = 0; i < computerNumbers.length; i++){
            final int index = i;
            count += Arrays.stream(computerNumbers).filter(x -> x == playerNumbers[index]).count();
        }
        return count;
    }

    public boolean showResult(){
        int strike = checkStrike();
        int ball = checkBall();

        if(ball + strike == 0){
            System.out.println("낫싱!");
        } else if(strike == 0) {
            System.out.println(ball + " 볼");
        } else if(ball == 0){
            System.out.println(strike + " 스트라이크");
        } else {
            System.out.println(strike + " 스트라이크 " + ball + " 볼");
        }

        return strike == 3;
    }

}
