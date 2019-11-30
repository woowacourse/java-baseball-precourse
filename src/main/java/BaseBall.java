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
    private int answer;
    private int userInput;
    private Scanner scanner;

    private void start() {
        this.answer = makeRandomNumber(MAX_NUMBER);

        while (true) {
            while (!getUserInput());

            printResult(this.answer, this.userInput);

            if (isCorrect(this.answer, this.userInput)) {
                break;
            }
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        checkContinue();
    }

    private void checkContinue() {
        int input;
        String guideMessage = new String("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = getUserInputAOrB(CONTINUE, EXIT, guideMessage);

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

            input = this.scanner.nextLine();
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

            System.out.println("잘못된 입력입니다. 다시 입력하세요.");
        }
    }

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

    private boolean isCorrect(int answer, int userInput) {
        if (answer == userInput) {
            return true;
        }
        return false;
    }

    private void printResult(int answer, int userInput) {
        boolean Nothing = false;
        int strikeCount = 0;
        int ballCount = 0;

        Nothing = checkNothingExist(answer, userInput);
        strikeCount = countStrike(answer, userInput);
        ballCount = countBall(answer, userInput, strikeCount);

        if (Nothing) {
            System.out.println("낫싱");
            return;
        }

        if (strikeCount > 0) {
            System.out.print(strikeCount+" 스트라이크 ");
        }
        if (ballCount > 0) {
            System.out.print(ballCount + " 볼");
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



    public static void main(String[] args) {
        BaseBall baseBall = new BaseBall();
//        baseBall.makeRandomNumber(MAX_NUMBER);
//        while (!baseBall.getUserInput());
//        baseBall.printResult(713, 123);
//        baseBall.printResult(713, 145);
//        baseBall.printResult(713, 671);
//        baseBall.printResult(713, 216);
//        baseBall.printResult(713, 713);
//        baseBall.printResult(789, 123);
//        baseBall.printResult(789, 456);
//        baseBall.printResult(789, 567);
//        baseBall.printResult(789, 678);
//        baseBall.printResult(789, 987);
//        baseBall.printResult(789, 789);
    }
}
