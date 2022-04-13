package baseball;

import baseball.play.Validation;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    	
    	boolean isContinue = true;
    	
    	while (isContinue) {
    		System.out.print("숫자를 입력해주세요 : ");
        	Validation.numberCheck(Console.readLine());
        	System.out.println("??");
        	Validation.numberCheck(Console.readLine());
        	System.out.println("????");
        	break;
		}
    	
    	
    }
}
