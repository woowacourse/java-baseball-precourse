package baseball;


import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Number number = new Number();

        int strike = 0;
        int ball = 0;

        while(true){
            try{
                number.setTarget();
                System.out.print("숫자를 입력해 주세요 : ");
                String input = scanner.next();
                number.setGuess(input);
                strike = number.strike();
                ball = number.ball();
                break;
            } catch(IllegalArgumentException e){
                System.out.println("잘못된 입력입니다. 1~9의 숫자로 이루어진 세자리 수를 입력해주세요");
                continue;
            }
        }


        scanner.close();
    }
}
