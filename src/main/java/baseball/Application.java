package baseball;

import utils.RandomUtils;
import java.util.Scanner;

public class Application {
    static final int NUMBER_LENGTH = 3;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;
    static final int MAX_STRIKE = 3;
    static int[] NumbersPickedByComputer = new int[NUMBER_LENGTH];
    static int[] NumbersPickedByPlayer = new int[NUMBER_LENGTH];
    static String[] playerInputString;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        while(true) {
            inputRandomAndNoDuplicationNumbers(NumbersPickedByComputer);
            printArray(NumbersPickedByComputer);
            playerInputAndCompareProcess(scanner);
            int answer = askPlayerGameRestart(scanner);
            if(answer == 1)
                continue;
            if(answer == 2)
                break;
        }
    }

    public static int askPlayerGameRestart(Scanner scanner) {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int answerPlayerInput;
        try {
            answerPlayerInput = scanner.nextInt();
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
        if(answerPlayerInput != 1 && answerPlayerInput != 2)
            throw new IllegalArgumentException("1과 2 중에 하나를 입력해주세요!");
        return answerPlayerInput;
    }

    public static void playerInputAndCompareProcess(Scanner scanner) {
        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            playerInputString = scanner.next().split("");
            inputPlayerNumbersToArray(playerInputString);
            if (compareComputerAndPlayer())
                break;
        }
    }

    public static boolean compareComputerAndPlayer() {
        int strike = countStrike();
        int ball = countBall(strike);
        if(strike != MAX_STRIKE) {
            printHint(strike, ball);
            return false; // 다시 입력
        }
        System.out.printf("%d스트라이크 \n%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", MAX_STRIKE, MAX_STRIKE);
        return true; // 게임 종료, 게임 다시 시작할지 완전히 종료할지 묻기

    }

    public static void printHint(int strike, int ball) {
        if(ball != 0)
            System.out.printf("%d볼 ", ball);
        if(strike != 0)
            System.out.printf("%d스트라이크", strike);
        if(ball == 0 && strike == 0)
            System.out.printf("낫싱");
        System.out.println();
    }

    public static int countStrike() {
        int strikeCounter = 0;
        for(int i = 0; i < NUMBER_LENGTH; i++) {
            if (NumbersPickedByComputer[i] == NumbersPickedByPlayer[i])
                strikeCounter++;
        }
        return strikeCounter;
    }
    public static int countBall(int strikeCounter) {
        int ballCounter = 0;
        for(int i = 0; i < NUMBER_LENGTH; i++) {
            if (isSameDigitInArray(NumbersPickedByComputer, NumbersPickedByPlayer[i]))
                ballCounter++;
        }
        return ballCounter - strikeCounter;
    }

    public static boolean isValidInput(String[] string) {
        if(!isRightLength(string, NUMBER_LENGTH) || !AreNumbers(string))
            return false;
        return true;
    }

    public static void inputPlayerNumbersToArray(String[] playerInputString) {
        initializeArray(NumbersPickedByPlayer);
        if(!isValidInput(playerInputString))
            throw new IllegalArgumentException();
        for(int i = 0; i < NUMBER_LENGTH; i++) {
            int numberPlayerInput = Integer.parseInt(playerInputString[i]);
            if(isSameDigitInArray(NumbersPickedByPlayer, numberPlayerInput)) {
                throw new IllegalArgumentException("중복된 숫자가 있어요!");
            }
            NumbersPickedByPlayer[i] = numberPlayerInput;
        }
    }

    public static boolean isRightLength(String[] string, int lengthLimit) {
        if(string.length != lengthLimit) {
            System.out.println(lengthLimit+" 자리의 숫자를 입력해주세요!");
            return false;
        }
        return true;
    }
    public static boolean AreNumbers(String[] string) {
        for(int i = 0; i<string.length; i++) {
            try {
                Integer.parseInt(string[i]);
            } catch (Exception e) {
                System.out.println("숫자(1~9)를 입력해주세요!");
                return false;
            }
        }
        return true;
    }
    public static boolean isSameDigitInArray(int[] array, int digit) {
        for(int i = 0; i < array.length; i++) {
            if(digit == array[i])
                return true;
        }
        return false;
    }

    public static void initializeArray(int[] array) {
        for(int i = 0; i < array.length; i++)
            array[i] = -1;
    }

    public static void inputRandomAndNoDuplicationNumbers(int[] array){
        initializeArray(NumbersPickedByComputer);
        for(int i = 0; i < NUMBER_LENGTH; i++) {
            int newDigit = RandomUtils.nextInt(MIN_NUMBER, MAX_NUMBER);
            if(isSameDigitInArray(array, newDigit)) {
                i -= 1;
                continue;
            }
            array[i] = newDigit;
        }
    }

    public static void printArray(int[] array){
        for(int i:array)
            System.out.printf("%d ", i);
        System.out.println();
    }


}
