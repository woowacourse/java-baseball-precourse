package baseball;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    private final Scanner scanner;
    private static final String wrongInput = "잘못된 입력입니다. 중복된 숫자가 없는 3자리 정수만 입력해주세요.";
    private static final String inputWords = "숫자를 입력해주세요 : ";
    ArrayList<Integer> inputNumber = null;

    public Player(Scanner scanner) {
        this.scanner = scanner;
    }

    public ArrayList<Integer> getInputNumber() {
        readInput();
        return inputNumber;
    }

    private int readInput() {
        boolean isValid;
        int number;
        while(true) {
            System.out.print(inputWords);
            number = checkIfNumber();
            isValid = checkDigit(number);
            if(isValid) {
                break;
            } else {
                System.out.println(wrongInput);
            }
        }

        return number;
    }

    private int checkIfNumber() {
        int num;
        try {
            num = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }

        return num;
    }

    private boolean checkDigit(int checkIfNumber) {
        int numberLen = (int)(Math.log10(checkIfNumber) + 1);
        return numberLen == 3;
    }

}
