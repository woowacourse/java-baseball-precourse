package baseball;

import java.util.Scanner;
import utils.RandomUtils;

/*
 *       숫자 야구 게임을 진행하는 클래스
 *       author: 483759/윤이진
 * */
public class Application {
    private static final int INPUT_NUM = 3;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        startGame(scanner);
        // TODO 구현 진행
    }

    /* 전반적인 게임 진행을 담당하는 메소드 */
    public static void startGame(Scanner scanner){
        String inputValue;
        boolean correctValue=false;
        Number comNum = setComputerNumber();
        while(!correctValue){
            printNumberInput();
            inputValue=getUserInput(scanner);
            correctValue=isValidInput(inputValue);
        }
    }

    public static Number setComputerNumber(){
        Number comNum = new Number(INPUT_NUM);
        for(int i=0;i<INPUT_NUM;i++){
            int randomNum=RandomUtils.nextInt(0,9);
            while(comNum.isUsedNumber(randomNum)){
                randomNum=RandomUtils.nextInt(0,9);
            }
            comNum.setArrayNumberAt(i,RandomUtils.nextInt(0,9));
        }
        return comNum;
    }

    /* 게임 진행을 위해 숫자를 입력하라는 안내를 출력하는 메소드 */
    public static void printNumberInput() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    /* 유저에게 숫자를 입력받아 반환하는 메소드 */
    public static String getUserInput(Scanner scanner) {
        String inputValue = scanner.next();
        return inputValue;
    }

    /* 유저가 입력한 숫자가 올바른 형식인지 검사하는 메소드 */
    public static boolean isValidInput(String inputValue) {
        boolean isValid = true;

        try {
            if(inputValue.length()!=INPUT_NUM){
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < inputValue.length(); i++) {
                // 개별 문자에 대해 형식이 맞는지 검사
                isValid &= isValidCharacter(inputValue.charAt(i));
            }
        } catch (IllegalArgumentException e){
            System.out.println("3자리 숫자를 입력해 주세요!");
            return false;
        }
        return isValid;
    }

    /* 해당 문자가 입력 요구사항에 일치하는지 검사하는 메소드 */
    public static boolean isValidCharacter(char inputCharacter) {
        try {
            if (inputCharacter < '1' || inputCharacter > '9') {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("1과 9 사이의 숫자를 입력해 주세요!");
            return false;
        }
        return true;
    }

}
