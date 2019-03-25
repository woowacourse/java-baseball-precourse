import java.util.List;
import java.util.Scanner;

public class BaseBallNumberGame {
    public static void main(String[] args) {
        int GAME_START = 1;
        BaseBallGameInput baseBallGameInput = new BaseBallGameInput();
        BaseBallGameOutput baseBallOutput = new BaseBallGameOutput();
        Scanner scanner = new Scanner(System.in);
        int gameProgressNum = GAME_START;
        BaseBallNumberGenerator baseBallNumberGenerator = new BaseBallNumberGenerator();
        List<BaseNumber> computerBaseBallNumber = baseBallNumberGenerator.getBaseBallNumbers();

        while(gameProgressNum == GAME_START) {
            baseBallGameInput.askBaseBallNumbers();
            int inputBaseBallNumber = scanner.nextInt();
            BaseBallNumber baseBallNumber = new BaseBallNumber(inputBaseBallNumber);
            List<BaseNumber> userBaseBallNumber = baseBallNumber.getBaseBallNumbers();
            BaseBallGameResult baseBallResult = new BaseBallGameResult(userBaseBallNumber, computerBaseBallNumber);
            baseBallOutput.printResult(baseBallResult);
            if(baseBallResult.getStrike() == 3) {
                baseBallGameInput.askGameRestartOrExit();
                gameProgressNum = scanner.nextInt();
                baseBallNumberGenerator = new BaseBallNumberGenerator();
                computerBaseBallNumber = baseBallNumberGenerator.getBaseBallNumbers();
            }
        }
    }
} 
