package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

import baseball.computer.Computer;
import baseball.umpire.Umpire;
import baseball.user.User;

public class Application {
	public static void main(String[] args) {
		// 컴퓨터, 유저, 심판 생성
		Computer computer;
		User user = new User();
		Umpire umpire = new Umpire();
		// 끝낼지 말지 정하는 변수 선언
		int end = 1;

		// 2를입력받을 때 까지 게임을 계속한다
		while (end == 1) {
			computer = new Computer();
			game(computer, user, umpire);
			umpire.init();
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			end = Integer.valueOf(readLine());
		}
	}

	// 게임을 하는 메소드
	private static void game(Computer computer, User user, Umpire umpire) {
		while (!umpire.isEnd()) {
			umpire.init();
			user.getInput();
			umpire.checkResult(computer.target, user.input);
		}
	}
}
