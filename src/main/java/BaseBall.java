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
    static final int CONTINUE = 1;
    static final int EXIT = 2;
    static final String MESSAGE_STRIKE = "스트라이크";
    static final String MESSAGE_BALL = "볼";
    static final String MESSAGE_NOTHING = "낫싱";
    static final String MESSAGE_END_OF_GAME = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String MESSAGE_NEW_GAME_OR_QUIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    static final String MESSAGE_WRONG_INPUT = "잘못된 입력입니다. 다시 입력하세요.";
    static final String MESSAGE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    static final String ERROR_MESSAGE_CONTAINS_CHAR = "문자가 입력되었습니다.\n다시 ";
    static final String ERROR_MESSAGE_IS_MINUS = "음수가 입력되었습니다. \n다시 ";
    static final String ERROR_MESSAGE_INPUT_LENGTH_IS_WRONG = "세 숫자가 입력되지 않았습니다.\n다시" ;
    static final String ERROR_MESSAGE_CONTAINS_ZERO = "입력한 문자 중 '0'이 포함되어 있습니다.\n다시 ";
    static final String ERROR_MESSAGE_CONTAINS_SAME_NUMBER = "같은 숫자가 포함되어 있습니다.\n다시 ";
    private int answer;
    private int userInput;
    private Scanner scanner;

    public BaseBall() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        this.answer = makeRandomNumber(MAX_NUMBER);

        while (true) {
            while (!getUserInput());

            printResult(this.answer, this.userInput);

            if (isCorrect(this.answer, this.userInput)) {
                break;
            }
        }

        System.out.println(INPUT_SIZE + MESSAGE_END_OF_GAME);
        checkContinue();
    }

    private void checkContinue() {
        int input;

        input = getUserInputAOrB(CONTINUE, EXIT, MESSAGE_NEW_GAME_OR_QUIT);

        if (input == CONTINUE) {
            start();
        }
        if (input == EXIT) {
            System.exit(0);
        }
    }

    private int getUserInputAOrB(int inputA, int inputB, String guideMessage) {
        String input;
        int inputValue;

        while (true) {
            if (guideMessage.length() > 0) {
                System.out.println(guideMessage);
            }

            input = this.scanner.next();
            if (checkInputContainsChar(input)) {
                continue;
            }

            inputValue = Integer.parseInt(input);
            if (inputValue == inputA) {
                return inputA;
            }
            if (inputValue == inputB) {
                return inputB;
            }

            System.out.println(MESSAGE_WRONG_INPUT);
        }
    }

    private int makeRandomNumber(int maxNumber) {
        int randomNumber1;
        int randomNumber2;
        int randomNumber3;
        int randomNumber;

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

        System.out.println(MESSAGE_INPUT_NUMBER);
        input  = this.scanner.next();

        if (checkInputContainsChar(input)) {
            return false;
        }
        if (checkInputIsMinus(input)) {
            return false;
        }
        if (!checkInputLengthIsCorrect(input, INPUT_SIZE)) {
            return false;
        }
        if (checkInputContainsZero(input)) {
            return false;
        }

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
            System.out.print(ERROR_MESSAGE_CONTAINS_CHAR);
            return true;
        }
        return false;
    }

    private boolean checkInputIsMinus(String input) {
        if (input.contains("-") == true) {
            System.out.print(ERROR_MESSAGE_IS_MINUS);
            return true;
        }
        return false;
}

    private boolean checkInputLengthIsCorrect(String input, int size) {
        if (input.length() != size) {
            System.out.print(ERROR_MESSAGE_INPUT_LENGTH_IS_WRONG);
            return false;
        }
        return true;
    }

    private boolean checkInputContainsZero(String input) {
        if (input.contains("0") == true) {
            System.out.print(ERROR_MESSAGE_CONTAINS_ZERO);
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
            System.out.print(ERROR_MESSAGE_CONTAINS_SAME_NUMBER);
            return true;
        }
        return false;
    }

    private boolean isCorrect(int answer, int userInput) {
        if (answer == userInput) {
            return true;
        }
        return false;
    }

    private void printResult(int answer, int userInput) {
        boolean Nothing;
        int strikeCount;
        int ballCount;

        Nothing = checkNothingExist(answer, userInput);
        strikeCount = countStrike(answer, userInput);
        ballCount = countBall(answer, userInput, strikeCount);

        if (Nothing) {
            System.out.println(MESSAGE_NOTHING);
            return;
        }

        if (strikeCount > 0) {
            System.out.print(strikeCount + " " + MESSAGE_STRIKE);
        }
        if (ballCount > 0) {
            System.out.print(ballCount + " " + MESSAGE_BALL);
        }
        System.out.println();

        return;
    }

    private boolean checkNothingExist(int answer, int userInput) {
        boolean isNothing = true;
        int[] checkArr = new int[MAX_NUMBER];
        int answerIndex;
        int userInputIndex;

        for (int i=0; i<INPUT_SIZE; i++) {
            answerIndex = answer % 10 - 1;
            userInputIndex = userInput % 10 - 1;
            checkArr[answerIndex]++;
            checkArr[userInputIndex]++;
            answer /= 10;
            userInput /= 10;
        }

        for (int i=0; i<MAX_NUMBER; i++) {
            if (checkArr[i] == 2) {
                isNothing = false;
            }
        }

        return isNothing;
    }

    private int countStrike(int answer, int userInput) {
        int count = 0;

        for (int i=0; i<INPUT_SIZE; i++) {
            if ((answer%10) == (userInput%10)) {
                count++;
            }
            answer /= 10;
            userInput /= 10;
        }

        return count;
    }

    private int countBall(int answer, int userInput, int strikeCount) {
        int count = 0;
        int[] checkArr = new int[MAX_NUMBER];
        int answerIndex;
        int userInputIndex;

        for (int i=0; i<INPUT_SIZE; i++) {
            answerIndex = answer % 10 - 1;
            userInputIndex = userInput % 10 - 1;
            checkArr[answerIndex]++;
            checkArr[userInputIndex]++;
            answer /= 10;
            userInput /= 10;
        }

        for (int i=0; i<MAX_NUMBER; i++) {
            if (checkArr[i]==2) {
                count++;
            }
        }

        count -= strikeCount;

        return count;
    }
}
