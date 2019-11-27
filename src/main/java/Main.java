import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        HashMap<Integer, Integer> numberMap = numberGenerator.generateNumbers();
        System.out.println("임의의 수: " + numberMap.toString());

        Scanner scanner = new Scanner(System.in);
        UserInput userInput = new UserInput(scanner);
        String number = userInput.getUserNumber();
        System.out.println(number);
    }
}
