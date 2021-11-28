package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameHost {

	// 게임 과정 진행시 필요한 객체의 인스턴스를 주입해주기 위한 설정 객체
	private Config config = new Config();

	// 3자리 무작위 숫자조합 생성, 저장
	private String targetNumber = config.randomNumber.makeRandomNumber();

	// 출력 메시지 상수
	private static final String INPUT_NUMBER_ASKING_MASSAGE = "숫자를 입력해주세요 : ";
	private static final String GAME_ENDING_MASSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String GAME_PLAY_OR_STOP_ASKING_MASSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	// 게임 진행 여부를 체크 하는 변수
	private int gameSwitch = 1;

	public void runGame() {
		while (gameSwitch == 1) {
			// 콘솔로 숫자를 입력 받는다.
			System.out.print(INPUT_NUMBER_ASKING_MASSAGE);
			String gameInputNumber = Console.readLine();

			// 게임을 하기 위한 인풋이 적절한지 검사
			config.gameInputChecking.inputCheck(gameInputNumber);

			// gameInputNumber 의 볼, 스트라이크를 계산하고 문자열로 생성한다.
			String calculateMassage = config.ballStrikeCalculator.calculate(gameInputNumber, targetNumber);

			// calculateMassage 를 콘솔로 출력
			System.out.println(calculateMassage);

			// 게이머가 입력한 값이 3스트라이크인 경우의 과정 실행
			handleThreeStrike(calculateMassage);
		}
	}

	public void handleThreeStrike(String calculateMassage) {
		if (calculateMassage.equals("3스트라이크")) {
			// 게임 종료 메시지 출력
			System.out.println(GAME_ENDING_MASSAGE);
			// 게임 진행 여부를 묻는 메시지 출력
			System.out.println(GAME_PLAY_OR_STOP_ASKING_MASSAGE);

			// 게임 진행 혹은 중단을 결정하는 값을 입력 받는다.
			String playOrStopInputNumber = Console.readLine();

			// 게임 진행 혹은 중단을 결정하는 값이 적절한 값인지 검사
			config.playOrStopInputChecking.inputCheck(playOrStopInputNumber);

			// 적절한 값일 경우 gameSwitch 변수에 대입
			gameSwitch = Integer.parseInt(playOrStopInputNumber);

			// 게임을 새로 시작할 경우 새로운 3자리 무작위 숫자조합 생성
			if (gameSwitch == 1) {
				targetNumber = config.randomNumber.makeRandomNumber();
			}
		}
	}
}
