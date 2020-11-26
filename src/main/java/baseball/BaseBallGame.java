package baseball;

import utils.BaseBallUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseBallGame {
    private final Scanner scanner;
    private final AnswerBalls answerBalls;
    private static final int START_NUM = 0;
    private ArrayList<Integer> inputBalls = new ArrayList<>();

    public BaseBallGame(Scanner scanner, AnswerBalls answerBalls){
        this.scanner = scanner;
        this.answerBalls = answerBalls;
    }

    public void nextBalls(){
        System.out.print("숫자를 입력해주세요 : ");

        String input = scanner.nextLine();
        int ballLength = input.length();

        for (int i = 0; i < ballLength; i++) {
            inputBalls.add((int) Character.getNumericValue(input.charAt(i)));
        }

        BaseBallUtils.isRigthBalls(inputBalls);
    }

    public ArrayList<Integer> getInputBalls() {
        return inputBalls;
    }
}
