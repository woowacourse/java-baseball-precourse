package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        int userInput;

        System.out.println("숫자를 입력해주세요 : ");
        userInput = scanner.nextInt();
        checkInputNumber(userInput);
    }
    public static void checkInputNumber(int numbers){
        if(numbers < 100 || numbers > 1000){
            throw new IllegalArgumentException("3자리 수가 아닙니다.");
        }
    }
}
