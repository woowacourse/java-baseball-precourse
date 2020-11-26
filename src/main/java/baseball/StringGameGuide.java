package baseball;

public class StringGameGuide {
	
	String startGame() {
		final String intro = "게임을 새로 시작 : 1번     게임 종료 : 2번";
		return intro;
	}
	
	String restartGame() {
		final String restart = "게임을 다시 시작 합니다.";
		return restart;
	}
	
	String gameOver() {
		final String over = "게임을 종료 합니다";
		return over;
	}
	
	String wrongSelect() {
		final String again = "다시 입력 하세요.";
		return again;
	}
}
