package baseball;

import baseball.model.Computer;
import baseball.model.User;
import baseball.play.Play;
import baseball.play.Validation;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    	
    	Computer computer = new Computer();
    	while (true) {
    		System.out.print("숫자를 입력해주세요 : ");
    		String inputNumber = Console.readLine();
			new Validation(inputNumber);
        	User user = new User(inputNumber);
        	if (Play.playBall(computer.getNumber(), user)) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

				if ("2".equals(Console.readLine())) {
					System.out.println("게임 종료");
					break;
				}
				computer = new Computer();
			};
		}
    	
    	
    }
}
