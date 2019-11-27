import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        HashMap<Integer, Integer> numberMap = numberGenerator.generateNumbers();
        System.out.println("임의의 수: " + numberMap.toString());

        Scanner scanner = new Scanner(System.in);
        UserInput userInput = new UserInput(scanner);

        NumberComparator numberComparator = new NumberComparator(numberMap);
        while (true) {
            String number = userInput.getUserNumber();
            numberComparator.setInputNumber(number);
            numberComparator.resetScoreboard();
            numberComparator.compareNumbers();
            if (numberComparator.isThreeStrikes()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            numberComparator.printScoreboard();
        }

    }
}
