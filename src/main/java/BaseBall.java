/*
 * BaseBall.java
 *
 * version 1.0
 *
 * 20191127
 *
 * copyright by jiwonSong
 *
 */

import java.util.Scanner;

public class BaseBall {

    static final int INPUT_SIZE = 3;
    static final int MAX_NUMBER = 9;
    private int answer;
    private int userInput;
    private int strikeCount=0;
    private int ballCount=0;
    private boolean isNothing = false;
    private Scanner scanner;

    private int makeRandomNumber(int maxNumber) {
        int randomNumber1 = 0;
        int randomNumber2 = 0;
        int randomNumber3 = 0;
        int randomNumber = 0;

        randomNumber1 = (int) (Math.random() * maxNumber + 1);

        while (true) {
            randomNumber2 = (int) (Math.random() * maxNumber + 1);
            if (randomNumber1!=randomNumber2) {
                break;
            }
        }

        while (true) {
            randomNumber3 = (int) (Math.random() * maxNumber + 1);
            if ((randomNumber1 != randomNumber3) && (randomNumber2 != randomNumber3)) {
                break;
            }
        }

        randomNumber = 100 * randomNumber1 + 10 * randomNumber2 + randomNumber3;
        return randomNumber;
    }


    private boolean getUserInput() {
        String input;
        int inputValue;
        Scanner scanner = new Scanner(System.in); //생성자에 추가

        System.out.println("숫자를 입력해주세요 : ");
        input  = scanner.next();

        if (checkInputContainsChar(input)) {
            return false;
        }
        if (!checkInputLengthIsCorrect(input, INPUT_SIZE)) {
            return false;
        }
        if (checkInputContainsZero(input)) {
            return false;
        }

        /*try {
            inputValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.print("문자가 입력되었습니다.\n다시 ");
            return false;
        }*/
        inputValue = Integer.parseInt(input);

        if (checkInputContainsSameNumber(inputValue)) {
            return false;
        }

        this.userInput = inputValue;
        return true;
    }

    private boolean checkInputContainsChar(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.print("문자가 입력되었습니다.\n다시 ");
            return true;
        }
        return false;
    }

    private boolean checkInputLengthIsCorrect(String input, int size) {
        if (input.length() != size) {
            System.out.print("세 숫자가 입력되지 않았습니다.\n다시 ");
            return false;
        }
        return true;
    }

    private boolean checkInputContainsZero(String input) {
        if (input.contains("0") == true) {
            System.out.print("입력한 문자 중 '0'이 포함되어 있습니다.\n다시 ");
            return true;
        }
        return false;
    }

    private boolean checkInputContainsSameNumber(int input) {
        int inputValue100 = input/100;
        int inputValue10 = input/10%10;
        int inputValue1 = input%10;
        int diffBetween100N10 = inputValue100 - inputValue10;
        int diffBetween10N1 = inputValue10 - inputValue1;
        int diffBetween1N100 = inputValue1 - inputValue100;

        if ((diffBetween100N10 * diffBetween10N1 * diffBetween1N100) == 0 ) {
            System.out.print("같은 숫자가 포함되어 있습니다.\n다시 ");
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        BaseBall baseBall = new BaseBall();
//        baseBall.makeRandomNumber(MAX_NUMBER);
//        while (!baseBall.getUserInput());

    }
}
