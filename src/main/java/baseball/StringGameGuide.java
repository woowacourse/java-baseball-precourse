package baseball;

public class StringGameGuide {
	
	public String game() {
		final String intro = "게임을 새로 시작 : 1번     게임 종료 : 2번";
		return intro;
	}
	
	public String startGame() {
		final String restart = "게임을 시작 합니다.";
		return restart;
	}
	
	public String gameOver() {
		final String over = "게임을 종료 합니다";
		return over;
	}
	
	public String wrongSelect() {
		final String again = "다시 입력 하세요.";
		return again;
	}
	
	public String InputNumbers() {
		final String input = "숫자를 입력하세요";
		return input;
	}

}
