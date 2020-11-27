package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        AnswerGenerator answerGenerator = new AnswerGenerator();
        ArrayList<Integer> answer = answerGenerator.answer;
        startGame(answer, scanner);
    }

    public static void startGame(ArrayList<Integer> answer, Scanner scanner) {
        Input input = new Input();
        System.out.println(answer);
        ArrayList<Integer> userInput = input.generateUserInputList(input.getUserInput(scanner));
        GameRule gameRule = new GameRule(answer, userInput);
        if (!gameRule.isWin()){
            startGame(answer, scanner);
        }
    }

}
