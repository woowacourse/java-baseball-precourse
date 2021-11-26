package baseball;

/**
 * 게임 플레이어를 생성해서 게임 로직을 구현한 클래스
 */
public class Application {
	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
		BaseballGamePlayer baseballGamePlayer = new BaseballGamePlayer();
		do {
			baseballGamePlayer.setRandomGoalNumberString();
			baseballGamePlayer.playBaseballGame();
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		} while (baseballGamePlayer.getNewGame());
	}
}