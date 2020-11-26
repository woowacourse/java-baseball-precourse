package baseball;

import java.util.Scanner;

/*
*       숫자 야구 게임을 진행하는 클래스
*       author: 483759/윤이진
* */
public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String inputValue;

        printNumberInput();
        inputValue=getUserInput(scanner);
        // TODO 구현 진행
    }

    /* 게임 진행을 위해 숫자를 입력하라는 안내를 출력하는 함수 */
    public static void printNumberInput(){
        System.out.print("숫자를 입력해 주세요 : ");
    }

    /* 유저에게 숫자를 입력받아 반환하는 함수 */
    public static String getUserInput(Scanner scanner){
        String inputValue=scanner.next();
        return inputValue;
    }

    /* 유저가 입력한 숫자가 올바른 형식인지 검사하는 함수 */
    public static boolean isValidInput(String inputValue){
        boolean isValid=false;
        for(int i=0;i<inputValue.length();i++){
            // 개별 문자에 대해 형식이 맞는지 검사
        }
        return  isValid;
    }

}
