package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Number number = new Number();

        int strike = 0;
        int ball = 0;

        number.setTarget();
        while(strike!=3){
            try{
                String input = scanner.next();
                number.setGuess(input);
            } catch(IllegalArgumentException e){
                System.out.println("잘못된 입력입니다. 1~9의 숫자로 이루어진 세자리 수를 입력해주세요");
                continue;
            }
        }


        scanner.close();
    }
}
