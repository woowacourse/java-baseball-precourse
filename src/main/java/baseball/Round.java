package baseball;

import java.util.Scanner;

public class Round {

    public static void playOneRound(Number number, Scanner scanner){
        while(true){
            try{
                System.out.print("숫자를 입력해 주세요 : ");
                String input = scanner.next();
                number.setGuess(input);
            } catch(IllegalArgumentException e){
                System.out.println("잘못된 입력입니다. 1~9의 숫자로 이루어진 세자리 수를 입력해주세요");
                continue;
            }
            Result.printResult(number.strike(), number.ball());
            if(number.strike()==3){
                break;
            }
        }
    }
}
