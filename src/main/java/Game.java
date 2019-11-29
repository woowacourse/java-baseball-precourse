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
        System.out.print("숫자를 입력해주세요 : ");
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
            System.out.println("낫싱!");
        } else if (strike == 0) {
            System.out.println(ball + " 볼");
        } else if (ball == 0){
            System.out.println(strike + " 스트라이크");
        } else {
            System.out.println(strike + " 스트라이크 " + ball + " 볼");
        }
        return strike == 3;
    }

    public void showRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    public boolean inputRestart(){
        showRestart();
        setComputerNumbers(randomGenerator());
        return input.nextInt() == 1;
    }
}
