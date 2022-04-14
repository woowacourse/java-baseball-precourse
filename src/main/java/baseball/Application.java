package baseball;

import baseball.model.Computer;
import baseball.model.User;
import baseball.play.Play;
import baseball.play.Validation;
import baseball.play.Validation.ValidType;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    	
    	boolean isContinue = true;
    	Computer computer = new Computer();
    	while (isContinue) {
    		System.out.print("숫자를 입력해주세요 : ");
    		String inputNumber = Console.readLine();
        	if (!ValidType.SUCCESS.equals(Validation.numberCheck(inputNumber))) {
        		throw new IllegalArgumentException("잘못된인수로 인해 종료.");
        	}
        	User user = new User(inputNumber);
        	Play.playBall(computer, user);
        	
        	if (true) {
        		computer = new Computer();
        	}
        	
        	if (isContinue) {
        		//TODO: true일때,
        		computer = new Computer();
        	}
        	
//        	break;
		}
    	
    	
    }
}
