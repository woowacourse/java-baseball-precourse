package baseball;

import utils.ThreeDigitsUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int targetNumber = ThreeDigitsUtils.generateBaseballNumber();
        System.out.println(targetNumber);

        while (true){
            System.out.print("숫자를 입력해주세요 : ");
            String inputString = scanner.nextLine();
            try {
                inputString = inputString.strip();
                int inputNumber = Integer.parseInt(inputString);
                if (ThreeDigitsUtils.isDistinctThreeDigits(inputNumber)){
                    System.out.println(inputNumber);
                } else {
                    throw new IllegalArgumentException("Input should be Distinct Three Digits Integer");
//                    System.out.println("Not Distinct Three Digits Number: " + inputNumber);
                }
            }
            catch (NumberFormatException e){
                throw new IllegalArgumentException("Input should be Integer");
//                System.out.println(e + " " + inputString);
            }
        }
    }
}
