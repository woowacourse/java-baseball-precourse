package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
	public static final int PLAY_GAME= 1;
	public static final int EXIT_GAME= 2;
	
	public Game() {
		
	}
	
	public void start() {
		int nowState= PLAY_GAME;
		Computer computer= new Computer();
		Round round= new Round(computer);
		while(nowState==PLAY_GAME) {
			round.init();
			round.play();
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			String userInput= readLine();
			//숫자 유효성 검사
		}
	}
	
	private void validateInputType(String userInput) {
		try {
			Integer.parseInt(userInput);
		}catch(NumberFormatException e){
			throw new IllegalArgumentException("Type Error: 숫자만 입력하세요.");
		}
	}
	
	private void validateRange(int userInput) {
		if(userInput<PLAY_GAME||userInput>EXIT_GAME) {
			throw new IllegalArgumentException("Range Error: 범위를 벗어난 숫자입니다.");
		}
	}

}
