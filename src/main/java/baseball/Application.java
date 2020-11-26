package baseball;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        int userInput;
        int[] inputNumber;

        System.out.println("숫자를 입력해주세요 : ");
        userInput = scanner.nextInt();
        checkInputNumber(userInput);
        inputNumber = createInputNumber(userInput);

        // 입출력 검증 테스트용
        System.out.println(Arrays.toString(inputNumber));
    }
    public static void checkInputNumber(int numbers){
        if(numbers < 100 || numbers > 1000){
            throw new IllegalArgumentException("3자리 수가 아닙니다.");
        }
    }
    public static int[] createInputNumber(int numbers){
        String temp = Integer.toString(numbers);
        int[] inputNumberArray = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++){
            inputNumberArray[i] = temp.charAt(i) - '0';
        }
        return inputNumberArray;
    }
}
