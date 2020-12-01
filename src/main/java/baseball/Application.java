package baseball;

import java.util.Scanner;

public class Application {

    public static final int MAX_NUM_SIZE = 3;
    public static final int MIN_INPUT_NUM = 123;
    public static final int MAX_INPUT_NUM = 987;

    public enum NumberOrder { FIRST, SECOND, THIRD }

    public int[] splitNumber(int input) {
        int[] resultSplit = new int[MAX_NUM_SIZE];
        int currentIndex = MAX_NUM_SIZE - 1;
        while (input > 0) {
            int currentRest = input % 10;
            input /= 10;
            resultSplit[currentIndex] = currentRest;
            currentIndex--;
        }
        return resultSplit;
    }

    public boolean hasDuplicateNumber(int input) {
        int[] eachNumber = splitNumber(input);
        if (eachNumber[NumberOrder.FIRST.ordinal()] == eachNumber[NumberOrder.SECOND.ordinal()]
            || eachNumber[NumberOrder.FIRST.ordinal()] == eachNumber[NumberOrder.THIRD.ordinal()]
            || eachNumber[NumberOrder.SECOND.ordinal()] == eachNumber[NumberOrder.THIRD.ordinal()]) {
            return true;
        } else {
            return false;
        }
    }

    public void inputValidation(int input) {
        if (input < MIN_INPUT_NUM || MAX_INPUT_NUM < input || hasDuplicateNumber(input)) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) throws IllegalArgumentException {
        final Scanner scanner = new Scanner(System.in);
        Application application = new Application();
        AskQuestion askQuestion = new AskQuestion();
        GameData gameData = new GameData();
        gameData.selectRandomNumber();

        while (askQuestion.getKeepGoing()) {
            try {
                // verify input
                System.out.print("숫자를 입력해주세요 : ");
                int userInput = scanner.nextInt();
                application.inputValidation(userInput);

                // game start
                GameRound gameRound = new GameRound(gameData, userInput);
                gameRound.playGameRound(scanner, askQuestion);
            } catch (Exception e) {
                System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
                scanner.nextLine(); // buffer flush
            }
        }
    }
}