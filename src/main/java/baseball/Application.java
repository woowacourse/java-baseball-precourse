package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        boolean isRestart;
        do {
            AnswerGenerator answerGenerator = new AnswerGenerator();
            ArrayList<Integer> answer = answerGenerator.answer;
            startGame(answer, scanner);
            isRestart = isRestart(scanner);
        } while (isRestart);
    }

    public static void startGame(ArrayList<Integer> answer, Scanner scanner) {
        ArrayList<Integer> userInput = userInput(scanner);
        GameRule gameRule = new GameRule(answer, userInput);
        if (!gameRule.isWin()){
            startGame(answer, scanner);
        }
    }

    public static ArrayList<Integer> userInput(Scanner scanner) {
        Input input = new Input(scanner);
        return input.userInput;
    }

    public static boolean isRestart(Scanner scanner) {
        String message = Input.getRestartOrGameEnd(scanner);
        return Input.isRestart(message);
    }

}
