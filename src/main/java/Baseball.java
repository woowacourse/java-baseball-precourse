import java.util.HashMap;
import java.util.Scanner;

public class Baseball {
    private Scanner scanner;
    private UserInput userInput;

    public Baseball() {
        this.scanner = new Scanner(System.in);
        this.userInput = new UserInput(this.scanner);
    }

    public void start() {
        NumberGenerator numberGenerator =  new NumberGenerator();
        HashMap<Integer, Integer> numberMap = numberGenerator.generateNumbers();
        NumberComparator numberComparator = new NumberComparator(numberMap);

        System.out.println("정답: " + numberMap.toString()); // for test

        while (true) {
            String number = this.userInput.getUserNumber();
            numberComparator.setInputNumber(number);
            numberComparator.resetScoreboard();
            numberComparator.compareNumbers();
            if (numberComparator.isThreeStrikes()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            numberComparator.printScoreboard();
        }
        askToRestart();
    }

    public void askToRestart() {
        if (this.userInput.isRestartingGame()) {
            start();
        }
    }
}
