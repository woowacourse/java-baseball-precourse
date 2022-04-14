package baseball.play;

import baseball.model.Computer;
import baseball.model.User;

public class Play {
	
	public static String playBall(Computer computer, User user) {
		String computerNumber = computer.getNumber();
		for(int i = 0; i < user.getNumbers().length; i++) {
			String userNumber = user.getNumbers()[i];
			if (computerNumber.indexOf(userNumber) == -1) {
				System.out.println("N");
				continue;
				// NOT
			}
			if (computerNumber.indexOf(userNumber) == i) {
				System.out.println("ST");
				continue;
				// ST
			}
			if (computerNumber.indexOf(userNumber) != i) {
				System.out.println("B");
				continue;
				// BALL
			}
		}
		
		
		return "";
	}
	
//	public void resultMsg() {
//	}
	
	
}
