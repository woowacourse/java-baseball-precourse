package baseball;

import utils.RandomUtils;

import java.util.Scanner;


public class Application {
    static final int NUMBER_LENGTH = 3;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;
    static int[] NumbersPickedByComputer = new int[NUMBER_LENGTH];
    static int[] NumbersPickedByPlayer = new int[NUMBER_LENGTH];

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        inputRandomAndNoDuplicationNumbers(NumbersPickedByComputer);
        printArray(NumbersPickedByComputer);
        System.out.print("숫자를 입력해주세요 : ");
        String playerInputString[] = scanner.next().split("");
        inputPlayerNumbersToArray(playerInputString);

        // 비교하기 -> 정답 맞출 경우 종료
        for(int i = 0; i < NUMBER_LENGTH; i++) {
            if(NumbersPickedByComputer[i] == NumbersPickedByPlayer[i]){
                System.out.println("정답!");
            } else {
                System.out.println("오답!");
            }
        }
        // 결과 출력
        // 다시 할지 묻기
        // 비정상적 입력에 대해서는 IllegalArgumentException을 발생시킨다.

    }

    public static boolean isValidInput(String[] string) {
        if(!isRightLength(string, NUMBER_LENGTH) || !AreNumbers(string))
            return false;
        return true;
    }

    public static void inputPlayerNumbersToArray(String[] playerInputString) {
        if(!isValidInput(playerInputString))
            throw new IllegalArgumentException();
        for(int i = 0; i < NUMBER_LENGTH; i++) {
            int numberPlayerInput = Integer.parseInt(playerInputString[i]);
            if(isSameDigitInArray(NumbersPickedByPlayer, numberPlayerInput)) {
                System.out.println("중복된 숫자가 있어요!");
                throw new IllegalArgumentException();
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

    public static void inputRandomAndNoDuplicationNumbers(int[] array){
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
