package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

	public static void main(String[] args) {

		// Application 실행시 필요한 인스턴스들을 주입해주기 위한 설정 객체
		Config config = new Config();

		// 3자리 무작위 숫자조합 생성
		String targetNumber = config.randomNumber.makeRandomNumber();

		// 게임 진행 여부를 체크 하는 변수
		int gameSwitch = 1;

		// 게임 시작
		while (gameSwitch == 1) {
			// 콘솔로 숫자를 입력 받는다.
			System.out.print("숫자를 입력해주세요 : ");
			String gameInputNumber = Console.readLine();

			// 게임을 하기 위한 인풋이 적절한지 검사
			config.gameInputChecking.inputCheck(gameInputNumber);

			// gameInputNumber 의 볼, 스트라이크를 계산하고 문자열로 생성한다.
			String calculateMassage = config.ballStrikeCalculator.calculate(gameInputNumber, targetNumber);

			// calculateMassage 를 콘솔로 출력
			System.out.println(calculateMassage);

			// 게이머가 입력한 값이 3스트라이크인 경우
			if (calculateMassage.equals("3스트라이크")) {
				// 게임 종료 메시지 출력
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				// 게임 진행 여부를 묻는 메시지 출력
				System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

				// 게임 진행 혹은 중단을 결정하는 값을 입력 받는다.
				String playOrStopInputNumber = Console.readLine();

				// 게임 진행 혹은 중단을 결정하는 값이 적절한 값인지 검사
				config.playOrStopInputChecking.inputCheck(playOrStopInputNumber);

				// 적절한 값일 경우 gameSwitch 변수에 대입
				gameSwitch = Integer.parseInt(playOrStopInputNumber);
			}

			// 게임을 새로 시작할 경우 새로운 3자리 무작위 숫자조합 생성
			if (calculateMassage.equals("3스트라이크") && gameSwitch == 1) {
				targetNumber = config.randomNumber.makeRandomNumber();
			}
		}
	}
}
