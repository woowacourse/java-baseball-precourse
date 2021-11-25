package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

	public static void main(String[] args) {

		// Application 실행시 필요한 인스턴스들을 주입해주기 위한 설정 객체
		Config config = new Config();

		// 게임 진행 여부를 체크 하는 변수
		boolean gameSwitch = true;

		// 게임 시작
		while (gameSwitch) {
			// 콘솔로 숫자를 입력 받는다.
			System.out.print("숫자를 입력해주세요 : ");
			String gameInput = Console.readLine();

			// 게임을 하기 위한 인풋이 적절한지 검사
			config.gameInputChecking.inputCheck(gameInput);
		}
	}
}
