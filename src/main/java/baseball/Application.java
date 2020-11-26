package baseball;

import utils.ThreeDigitsUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        boolean onGame = true;
        while (onGame) {
            int targetNumber = ThreeDigitsUtils.generateBaseballNumber();
            System.out.println(targetNumber);
            Game game = new Game(targetNumber);
            boolean isCorrect = false;
            while (!isCorrect) {
                System.out.print("숫자를 입력해주세요 : ");
                String inputString = scanner.nextLine();
                try {
                    inputString = inputString.strip();
                    int inputNumber = Integer.parseInt(inputString);
                    if (ThreeDigitsUtils.isDistinctThreeDigits(inputNumber)) {
                        System.out.println(inputNumber);
                        String hint = game.getHint(inputNumber);
                        System.out.println(hint);
                        isCorrect = game.isAnswer(inputNumber);
                    } else {
                        throw new IllegalArgumentException("Input should be Distinct Three Digits Integer");
                        //                    System.out.println("Not Distinct Three Digits Number: " + inputNumber);
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Input should be Integer");
                    //                System.out.println(e + " " + inputString);
                }
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String inputString = scanner.nextLine();
            try {
                inputString = inputString.strip();
                int inputNumber = Integer.parseInt(inputString);
                if (inputNumber == 1) {
                    continue;
                } else if (inputNumber == 2) {
                    onGame = false;
                } else {
                    throw new IllegalArgumentException("Input should be 1 ro 2");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Input should be Integer");
                //                System.out.println(e + " " + inputString);
            }
        }
    }
}
