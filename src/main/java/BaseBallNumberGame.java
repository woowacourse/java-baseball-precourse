import java.util.List;
import java.util.Scanner;

public class BaseBallNumberGame {
    public static void main(String[] args) {
        BaseBallGameInput baseBallGameInput = new BaseBallGameInput();
        Scanner scanner = new Scanner(System.in);

        baseBallGameInput.askBaseBallNumbers();
        int inputBaseBallNumber = scanner.nextInt();
        BaseBallNumber baseBallNumber = new BaseBallNumber(inputBaseBallNumber);
        List<BaseNumber> userBaseBallNumber = baseBallNumber.getBaseBallNumbers();

    }
} 
